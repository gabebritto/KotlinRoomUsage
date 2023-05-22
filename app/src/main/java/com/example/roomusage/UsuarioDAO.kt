package com.example.roomusage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDAO {

    @Insert
    fun insert(user: Usuario)

    @Query("SELECT * FROM Usuario")
    fun getAllUsers(): List<Usuario>
}