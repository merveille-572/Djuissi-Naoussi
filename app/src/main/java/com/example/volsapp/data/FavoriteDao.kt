package com.example.volsapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {

    // Insérer un favori
    @Insert
    suspend fun insertFavorite(favorite: Favorite)

    // Récupérer tous les favoris
    @Query("SELECT * FROM favorite")
    suspend fun getAllFavorites(): List<Favorite> // Retourner une List<Favorite>

    // Récupérer un favori par code d'aéroport
    @Query("SELECT * FROM favorite WHERE airportCode = :airportCode")
    suspend fun getFavoriteByCode(airportCode: String): Favorite?
}
