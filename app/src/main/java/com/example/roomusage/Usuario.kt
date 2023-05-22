package com.example.roomusage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "matricula")
    val matricula: String
    ){

    override fun toString(): String {
        return "Usuário: " + this.name + " Matrícula: " + this.matricula
    }
}