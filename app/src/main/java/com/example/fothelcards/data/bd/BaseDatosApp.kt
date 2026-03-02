package com.example.fothelcards.datos.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fothelcards.datos.daos.UsuarioDao
import com.example.fothelcards.datos.entidades.UsuarioEntity

@Database(entities = [UsuarioEntity::class], version = 1)
abstract class BaseDatosApp : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile
        private var INSTANCIA: BaseDatosApp? = null

        fun obtenerInstancia(contexto: Context): BaseDatosApp {
            return INSTANCIA ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    contexto.applicationContext,
                    BaseDatosApp::class.java,
                    "fothelcards_bd"
                ).build()
                INSTANCIA = instancia
                instancia
            }
        }
    }
}