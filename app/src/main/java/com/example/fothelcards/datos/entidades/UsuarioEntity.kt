package com.example.fothelcards.datos.entidades // Asegúrate de que ponga 'datos'

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_usuarios") // Debe coincidir con el DAO
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val correo: String,      // Antes era 'email'
    val contrasena: String   // Antes era 'password'
)