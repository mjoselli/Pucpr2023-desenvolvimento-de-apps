package com.pucpr.myrecyclerview.controller

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pucpr.myrecyclerview.OnItemClicked
import com.pucpr.myrecyclerview.databinding.ItemViewBinding
import com.pucpr.myrecyclerview.model.City
import com.pucpr.myrecyclerview.model.Singleton

class CityAdapter(val clickListener: OnItemClicked) :RecyclerView.Adapter<CityAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(city: City, clickListener: OnItemClicked){
            binding.city = city
            binding.root.setOnClickListener{
                clickListener.onItemClicked(it,adapterPosition)
            }
            binding.root.setOnLongClickListener {
                clickListener.onItemLongClicked(it,adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    private lateinit var binding: ItemViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        Log.d("Adapter","Item Created")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Singleton.citiesArray[position].apply {
            holder.bind(this,clickListener)
        }
        Log.d("Adapter","Item Bind "+position)

    }

    override fun getItemCount() = Singleton.citiesArray.size
}