package com.pucpr.myrecyclerview.model

import androidx.room.*
import com.pucpr.myrecyclerview.model.City

@Dao
interface CityDAO {
    @Query("Select * from City")
    fun getAll():List<City>

    @Insert
    fun insertAll(vararg city: City)

    @Update
    fun updateCity(city: City):Int

    @Delete
    fun deleteCity(city: City):Int
}