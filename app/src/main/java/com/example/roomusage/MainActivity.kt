package com.example.roomusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var db: UsuarioDatabase
    private lateinit var tvName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvName = findViewById(R.id.tvName)

        db = Room.databaseBuilder(
            applicationContext,
            UsuarioDatabase::class.java, "usuario-database"
        ).build()

        this.insertUsuarios()
    }

    private fun insertUsuarios() {
        val usuarios = listOf<String>("Gabriel", "Paulo", "Victor")
        val random = Random()

        for (user in usuarios) {
            db.usuarioDAO().insert(Usuario(name = user, matricula = random.nextInt().toString()))
        }

        val users = db.usuarioDAO().getAllUsers()

        val finalText = StringBuilder()
        for (user in users) {
            finalText.append("ID: ${user.id} Nome: ${user.name} Matricula: ${user.matricula}")
        }

        this.tvName.text = finalText.toString()
    }
}