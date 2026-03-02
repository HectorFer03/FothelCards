package com.example.fothelcards.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.fothelcards.ui.viewmodels.AutenticacionViewModel

@Composable
fun PantallaRegistro(
    viewModel: AutenticacionViewModel,
    alRegistrarConExito: () -> Unit,
    volverAtras: () -> Unit
) {
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    val estado by viewModel.estadoAutenticacion.collectAsState()

    LaunchedEffect(estado) {
        if (estado == "REGISTRO_EXITOSO") alRegistrarConExito()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Registro", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico (Obligatorio)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (estado.startsWith("Error")) {
            Text(estado, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(onClick = { viewModel.registrar(correo, contrasena) }, modifier = Modifier.fillMaxWidth()) {
            Text("Crear cuenta")
        }
        TextButton(onClick = volverAtras) {
            Text("Volver atrás")
        }
    }
}