package com.example.volsapp.data

class RoomRepository(private val airportDao: AirportDao, private val favoriteDao: FavoriteDao) {

    fun searchAirports(query: String): List<Airport> {
        return airportDao.searchAirports(query)
    }

    suspend fun addFavorite(favorite: Favorite) {
        favoriteDao.insertFavorite(favorite)
    }

    suspend fun getFavorites(): List<Favorite> {
        return favoriteDao.getAllFavorites()
    }
}
