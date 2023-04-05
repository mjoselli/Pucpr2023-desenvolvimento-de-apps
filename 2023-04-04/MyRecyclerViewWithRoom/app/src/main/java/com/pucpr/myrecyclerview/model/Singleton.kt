package com.pucpr.myrecyclerview.model

import android.content.Context

object Singleton {
    lateinit var citiesArray:List<City>
    lateinit var dao: CityDAO
    fun setContext(context: Context){
        CityDatabase.getInstance(context)?.apply {
            dao = cityDao()
            citiesArray = dao.getAll()
        }
    }
    fun addCity(city: City){
        dao.insertAll(city)
        citiesArray = dao.getAll()
    }
    fun updateCity(city: City){
        dao.updateCity(city)
        citiesArray = dao.getAll()
    }
    fun deleteCity(city: City){
        dao.deleteCity(city)
        citiesArray = dao.getAll()
    }
}