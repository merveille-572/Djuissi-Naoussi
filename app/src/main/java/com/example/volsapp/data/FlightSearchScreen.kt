package com.example.volsapp.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FlightSearchScreen(viewModel: FlightViewModel = viewModel()) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    val airports by viewModel.airports.observeAsState(emptyList())
    val favorites by viewModel.favorites.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = {
                query = it
                viewModel.searchAirports(query.text)
            },
            label = { Text("Search Airport") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (query.text.isNotEmpty()) {
            LazyColumn {
                items(airports) { airport ->
                    Text("${airport.iataCode} - ${airport.name}")
                }
            }
        } else {
            LazyColumn {
                items(favorites) { favorite ->
                    Text("${favorite.departureCode} to ${favorite.destinationCode}")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val newFavorite = Favorite(
                departureCode = "NYC", destinationCode = "LAX",
                id = TODO(),
                airportCode = TODO()
            )
            viewModel.addFavorite(newFavorite)
        }) {
            Text("Add Favorite")
        }
    }
}

@Preview
@Composable
fun PreviewFlightSearchScreen() {
    FlightSearchScreen()
}
