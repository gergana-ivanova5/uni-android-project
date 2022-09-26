package com.example.exam090921_k.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam090921_k.R
import com.example.exam090921_k.holders.TownViewHolder
import com.example.exam090921_k.models.Town

class TownAdapter(private var townList: MutableList<Town>): RecyclerView.Adapter<TownViewHolder>() {

   // private val townList = mutableListOf<Town>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TownViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TownViewHolder(v)
    }

    override fun onBindViewHolder(holder: TownViewHolder, position: Int) {
        val town = townList.get(position)
        holder.setName(town.name)
        holder.setTemperature(town.temperature.toString() +"C")
        holder.setButtonOnCLickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                delete(town)
            }
        })

        holder.setOnClickListener(town.temperature)
    }

    private fun delete(town: Town) {
        if(townList.size>0){
            val position = townList.indexOf(town)
            townList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
       return townList.size
    }

    fun add(town:Town){
        townList.add(0, town)
        notifyItemInserted(0)
    }

    fun edit(town: Town){
        if(townList.size>0){
            val position = townList.indexOf(town)
            notifyItemChanged(position)
        }
    }
    fun getItems():List<Town>{
        return townList
    }
}