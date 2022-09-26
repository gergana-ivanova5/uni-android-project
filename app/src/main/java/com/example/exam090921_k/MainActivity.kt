package com.example.exam090921_k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam090921_k.adapters.TownAdapter
import com.example.exam090921_k.data.StorageData
import com.example.exam090921_k.fragments.TownFragment
import com.example.exam090921_k.listeners.OnTempChangedListener
import com.example.exam090921_k.listeners.OnTownAddListener
import com.example.exam090921_k.models.Town
import com.example.exam090921_k.tasks.ChangeTempTask
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), OnTownAddListener, OnTempChangedListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonMain: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewMain)
        buttonMain = findViewById(R.id.buttonMain)

        var adapter = TownAdapter(StorageData.generateTowns(10))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonMain.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                var newTown: Town = Town("NewTown", 0)
                var fragment: TownFragment = TownFragment.newInstance(newTown)
                fragment.show(supportFragmentManager,"Add")
            }
        })

        Thread(ChangeTempTask(this, adapter.getItems() as MutableList<Town>)).start()
    }

    override fun onTempChanged(town: Town) {
       this@MainActivity.runOnUiThread(java.lang.Runnable {
           var adapter: TownAdapter = recyclerView.adapter as TownAdapter
           adapter.edit(town)
       })
    }


    override fun onTownAdd(town: Town) {
        if(recyclerView!= null){
            var adapter: TownAdapter = recyclerView.adapter as TownAdapter
            adapter.add(town)
        }
    }
}