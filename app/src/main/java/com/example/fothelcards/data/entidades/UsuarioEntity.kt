package com.example.fothelcards.data.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String, // Obligatorio como pediste
    val password: String
)