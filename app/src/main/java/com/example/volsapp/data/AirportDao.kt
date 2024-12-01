package com.example.volsapp.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AirportDao {

    @Query("SELECT * FROM airport WHERE iata_code LIKE :query OR name LIKE :query ORDER BY passengers DESC")
    fun searchAirports(query: String): List<Airport>
}
