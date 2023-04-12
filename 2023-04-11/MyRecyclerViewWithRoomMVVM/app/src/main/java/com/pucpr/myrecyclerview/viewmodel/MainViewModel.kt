package com.pucpr.myrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pucpr.myrecyclerview.model.City
import com.pucpr.myrecyclerview.model.Singleton

class MainViewModel : ViewModel(){
    var citiesLiveData = MutableLiveData<List<City>>()
    fun add(city: City){
        Singleton.addCity(city)
        citiesLiveData.value = Singleton.citiesArray
    }
    fun remove(city: City){
        Singleton.deleteCity(city)
        citiesLiveData.value = Singleton.citiesArray
    }
    fun update(city: City){
        Singleton.updateCity(city)
        citiesLiveData.value = Singleton.citiesArray
    }
}