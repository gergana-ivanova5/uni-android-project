package com.example.exam090921_k.holders

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.exam090921_k.R

class TownViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private  var name:TextView
    private  var temperature:TextView
    private  var buttonDelete: Button

    init {
       name = itemView.findViewById(R.id.textViewName);
        temperature = itemView.findViewById(R.id.textViewTemp);
        buttonDelete = itemView.findViewById(R.id.buttonDelete);
    }

    fun setName(name: String) {
        this.name.text = name
    }

    fun setTemperature(temperature: String) {
        this.temperature.text = temperature
    }

    fun setButtonOnCLickListener(listener:View.OnClickListener){
        this.buttonDelete.setOnClickListener(listener)
    }

    fun setOnClickListener(temperature: Int){
        this.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (temperature >= 10 && temperature <= 15) {
                    Toast.makeText(itemView.context, "Времето е прохладно", Toast.LENGTH_SHORT)
                        .show()
                } else if (temperature >= 16 && temperature <= 20) {
                    Toast.makeText(itemView.context, "Времето е топло", Toast.LENGTH_SHORT).show()
                } else if (temperature >= 21 && temperature <= 30) {
                    Toast.makeText(itemView.context, "Времето е горещо", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}