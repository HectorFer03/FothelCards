package com.example.fothelcards.datos.repositorios

import com.example.fothelcards.datos.daos.UsuarioDao
import com.example.fothelcards.datos.entidades.UsuarioEntity

class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    suspend fun anadirUsuario(usuario: UsuarioEntity) {
        usuarioDao.insertarUsuario(usuario)
    }

    suspend fun iniciarSesion(correo: String, contrasena: String): UsuarioEntity? {
        return usuarioDao.iniciarSesion(correo, contrasena)
    }

    suspend fun comprobarCorreoExiste(correo: String): Boolean {
        return usuarioDao.obtenerUsuarioPorCorreo(correo) != null
    }
}