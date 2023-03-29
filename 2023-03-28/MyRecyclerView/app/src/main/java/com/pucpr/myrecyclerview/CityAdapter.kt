package com.pucpr.myrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(val clickListener:OnItemClicked) :RecyclerView.Adapter<CityAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView1:TextView
        val textView2:TextView
        init {
            textView1 = itemView.findViewById(R.id.text_view1)
            textView2 = itemView.findViewById(R.id.text_view2)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view,parent,false)
        Log.d("Adapter","Item Created")
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Singleton.citiesArray[position].apply {
            holder.textView1.text = this.name
            holder.textView2.text = this.population.toString()
            holder.itemView.setOnClickListener{
                clickListener.onItemClicked(it,
                position)
            }
            holder.itemView.setOnLongClickListener{
                clickListener.onItemLongClicked(it,
                    position)
                return@setOnLongClickListener true
            }
        }
        Log.d("Adapter","Item Bind "+position)

    }

    override fun getItemCount() = Singleton.citiesArray.size
}