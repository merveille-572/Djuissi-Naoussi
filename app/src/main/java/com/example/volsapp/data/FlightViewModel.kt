package com.example.volsapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FlightViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RoomRepository
    private val _airports = MutableLiveData<List<Airport>>()
    val airports: LiveData<List<Airport>> get() = _airports

    private val _favorites = MutableLiveData<List<Favorite>>()
    val favorites: LiveData<List<Favorite>> get() = _favorites

    init {
        val airportDao = FlightDatabase.getDatabase(application).airportDao()
        val favoriteDao = FlightDatabase.getDatabase(application).favoriteDao()
        repository = RoomRepository(airportDao, favoriteDao)
    }

    fun searchAirports(query: String) {
        _airports.value = repository.searchAirports(query)
    }

    suspend fun getFavorites() {
        _favorites.value = repository.getFavorites()
    }

    fun addFavorite(favorite: Favorite) {
        viewModelScope.launch {
            repository.addFavorite(favorite)
        }
    }
}
