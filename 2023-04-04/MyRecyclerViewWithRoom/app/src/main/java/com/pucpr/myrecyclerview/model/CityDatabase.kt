package com.pucpr.myrecyclerview.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [City::class], version = 1)
abstract class CityDatabase :RoomDatabase() {
    abstract fun cityDao() : CityDAO
    companion object{
        private var INSTANCE: CityDatabase? = null
        fun getInstance(context: Context): CityDatabase?{
            if(INSTANCE == null){
                synchronized(CityDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CityDatabase::class.java,
                        "city.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
        fun destroyDatabase(){
            INSTANCE = null
        }
    }
}