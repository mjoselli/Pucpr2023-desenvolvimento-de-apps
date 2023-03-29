package com.pucpr.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var addButton: Button
    lateinit var adapter: CityAdapter



    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        adapter = CityAdapter(clickListener = object :OnItemClicked{
            override fun onItemClicked(view: View, position: Int) {
                Singleton.citiesArray[position].apply {
                    this.name += " clicked"
                }
                adapter.notifyItemChanged(position)
            }

            override fun onItemLongClicked(view: View, position: Int) {
                Singleton.citiesArray.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener{
            Singleton.citiesArray.add(
                City("City "+num, num.toLong())
            )
            num++
            adapter.notifyItemInserted(Singleton.citiesArray.size-1)
        }
    }
}