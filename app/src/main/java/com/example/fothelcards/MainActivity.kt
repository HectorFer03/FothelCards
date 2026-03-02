package com.example.fothelcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fothelcards.datos.bd.BaseDatosApp
import com.example.fothelcards.datos.repositorios.UsuarioRepository
import com.example.fothelcards.ui.theme.FothelCardsTheme
import com.example.fothelcards.ui.viewmodels.AutenticacionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val baseDatos = BaseDatosApp.obtenerInstancia(applicationContext)
        val repositorio = UsuarioRepository(baseDatos.usuarioDao())
        val viewModelAutenticacion = AutenticacionViewModel(repositorio)

        setContent {
            FothelCardsTheme {
                NavegacionApp(viewModel = viewModelAutenticacion)
            }
        }
    }
}