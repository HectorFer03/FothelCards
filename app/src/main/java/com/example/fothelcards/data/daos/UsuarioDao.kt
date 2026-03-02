package com.example.fothelcards.datos.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fothelcards.datos.entidades.UsuarioEntity

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarUsuario(usuario: UsuarioEntity)

    @Query("SELECT * FROM tabla_usuarios WHERE correo = :correo AND contrasena = :contrasena LIMIT 1")
    suspend fun iniciarSesion(correo: String, contrasena: String): UsuarioEntity?

    @Query("SELECT * FROM tabla_usuarios WHERE correo = :correo LIMIT 1")
    suspend fun obtenerUsuarioPorCorreo(correo: String): UsuarioEntity?
}