package com.example.fothelcards.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Coleccionable(val titulo: String, val categoria: String)

@Composable
fun PantallaInicio() {
    val productos = listOf(
        Coleccionable("Manga One Piece Vol.1", "Manga"),
        Coleccionable("Carta Charizard Base Set", "Cartas"),
        Coleccionable("Figura Iron Man", "Figuras"),
        Coleccionable("Cómic Spider-Man #1", "Cómics")
    )

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Text("Catálogo FothelCards", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(productos) { producto ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(producto.titulo, style = MaterialTheme.typography.titleMedium)
                    Text(producto.categoria, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}