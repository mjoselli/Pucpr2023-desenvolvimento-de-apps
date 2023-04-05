package com.pucpr.myrecyclerview.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.pucpr.myrecyclerview.OnItemClicked
import com.pucpr.myrecyclerview.R
import com.pucpr.myrecyclerview.databinding.ActivityMainBinding
import com.pucpr.myrecyclerview.model.City
import com.pucpr.myrecyclerview.model.Singleton

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CityAdapter

    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Singleton.setContext(this)
        adapter = CityAdapter(clickListener = object : OnItemClicked {
            override fun onItemClicked(view: View, position: Int) {
                Singleton.citiesArray[position].apply {
                    this.name += " clicked"
                    Singleton.updateCity(this)
                }
                adapter.notifyItemChanged(position)
            }

            override fun onItemLongClicked(view: View, position: Int) {
                Singleton.citiesArray[position].apply {
                    Singleton.deleteCity(this)
                }
                adapter.notifyItemRemoved(position)
            }
        })
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.addButton.setOnClickListener{
            Singleton.addCity(
                City("City "+num, num.toLong())
            )
            num++
            adapter.notifyItemInserted(Singleton.citiesArray.size-1)
        }
    }
}