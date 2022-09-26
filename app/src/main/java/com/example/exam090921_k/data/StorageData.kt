package com.example.exam090921_k.data

import com.example.exam090921_k.models.Town
import kotlin.random.Random

class StorageData {

    companion object{
        fun generateTowns(number:Int):MutableList<Town>{
            var newList = mutableListOf<Town>()
            var i = 0
            while(i<number){
                newList.add(generateTown("TownName"+i))
                i++
            }
        return newList
        }

        fun generateTown(s:String): Town {
            var temperature = Random.nextInt(31)
            return Town(s, temperature)
        }
    }
}