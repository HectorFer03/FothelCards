package com.example.fothelcards

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fothelcards.ui.screens.PantallaInicio
import com.example.fothelcards.ui.screens.PantallaInicioSesion
import com.example.fothelcards.ui.screens.PantallaRegistro
import com.example.fothelcards.ui.viewmodels.AutenticacionViewModel
import kotlinx.serialization.Serializable

@Serializable
object RutaInicioSesion

@Serializable
object RutaRegistro

@Serializable
object RutaInicio

@Composable
fun NavegacionApp(viewModel: AutenticacionViewModel) {
    val controladorNavegacion = rememberNavController()

    Scaffold { paddingInterior ->
        NavHost(
            navController = controladorNavegacion,
            startDestination = RutaInicioSesion,
            modifier = Modifier.padding(paddingInterior)
        ) {
            composable<RutaInicioSesion> {
                PantallaInicioSesion(
                    viewModel = viewModel,
                    alIniciarSesionConExito = {
                        viewModel.restablecerEstado()
                        controladorNavegacion.navigate(RutaInicio) {
                            popUpTo(RutaInicioSesion) { inclusive = true }
                        }
                    },
                    irAlRegistro = {
                        viewModel.restablecerEstado()
                        controladorNavegacion.navigate(RutaRegistro)
                    }
                )
            }

            composable<RutaRegistro> {
                PantallaRegistro(
                    viewModel = viewModel,
                    alRegistrarConExito = {
                        viewModel.restablecerEstado()
                        controladorNavegacion.popBackStack()
                    },
                    volverAtras = {
                        viewModel.restablecerEstado()
                        controladorNavegacion.popBackStack()
                    }
                )
            }

            composable<RutaInicio> {
                PantallaInicio()
            }
        }
    }
}

