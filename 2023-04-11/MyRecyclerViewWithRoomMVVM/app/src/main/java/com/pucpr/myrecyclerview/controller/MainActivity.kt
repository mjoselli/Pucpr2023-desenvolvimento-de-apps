package com.pucpr.myrecyclerview.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pucpr.myrecyclerview.OnItemClicked
import com.pucpr.myrecyclerview.R
import com.pucpr.myrecyclerview.databinding.ActivityMainBinding
import com.pucpr.myrecyclerview.model.City
import com.pucpr.myrecyclerview.model.Singleton
import com.pucpr.myrecyclerview.viewmodel.MainViewModel
import com.pucpr.myrecyclerview.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CityAdapter
    private lateinit var viewModel: MainViewModel

    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Singleton.setContext(this)
        val factory = MainViewModelFactory()
        viewModel = factory.create(MainViewModel::class.java)

        adapter = CityAdapter(clickListener = object : OnItemClicked {
            override fun onItemClicked(view: View, position: Int) {
                Singleton.citiesArray[position].apply {
                    this.name += " clicked"
                    viewModel.update(this)
                    Snackbar.make(binding.root,
                    "Item updated",Snackbar.LENGTH_LONG)
                        .setAction("Remove"){
                            this.name = this.name.replace(" clicked","")
                            viewModel.update(this)
                        }
                        .show()
                }
            }

            override fun onItemLongClicked(view: View, position: Int) {
                Singleton.citiesArray[position].apply {
                    viewModel.remove(this)
                }
            }
        })
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.addButton.setOnClickListener{
            viewModel.add(
                City("City "+num, num.toLong())
            )
            num++
        }
        viewModel.citiesLiveData.observe(this, Observer {
            adapter.notifyDataSetChanged()
        })
    }
}