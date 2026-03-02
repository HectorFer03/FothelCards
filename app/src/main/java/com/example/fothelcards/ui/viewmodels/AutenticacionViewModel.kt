package com.example.fothelcards.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fothelcards.datos.entidades.UsuarioEntity
import com.example.fothelcards.datos.repositorios.UsuarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AutenticacionViewModel(private val repositorio: UsuarioRepository) : ViewModel() {

    private val _estadoAutenticacion = MutableStateFlow("")
    val estadoAutenticacion: StateFlow<String> = _estadoAutenticacion

    fun iniciarSesion(correo: String, contrasena: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val usuario = repositorio.iniciarSesion(correo, contrasena)
            if (usuario != null) {
                _estadoAutenticacion.value = "EXITO"
            } else {
                _estadoAutenticacion.value = "Error: Credenciales incorrectas"
            }
        }
    }

    fun registrar(correo: String, contrasena: String) {
        if (correo.isBlank() || !correo.contains("@")) {
            _estadoAutenticacion.value = "Error: El correo es obligatorio y debe ser válido"
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val existe = repositorio.comprobarCorreoExiste(correo)
            if (!existe) {
                repositorio.anadirUsuario(UsuarioEntity(correo = correo, contrasena = contrasena))
                _estadoAutenticacion.value = "REGISTRO_EXITOSO"
            } else {
                _estadoAutenticacion.value = "Error: El correo ya está registrado"
            }
        }
    }

    fun restablecerEstado() {
        _estadoAutenticacion.value = ""
    }
}