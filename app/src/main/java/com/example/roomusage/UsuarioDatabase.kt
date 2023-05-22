package com.example.roomusage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDatabase : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO
}