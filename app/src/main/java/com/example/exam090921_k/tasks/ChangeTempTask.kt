package com.example.exam090921_k.tasks

import android.os.Handler
import android.os.HandlerThread
import com.example.exam090921_k.listeners.OnTempChangedListener
import com.example.exam090921_k.models.Town
import java.security.SecureRandom
import kotlin.random.Random

class ChangeTempTask(private var listener: OnTempChangedListener, private var list:MutableList<Town>): Runnable {

    private var thread: HandlerThread
    private var handler: Handler

    init {
        thread = HandlerThread("Add")
        thread.start()
        handler = Handler(thread.looper)
    }

    override fun run() {
        var rand: SecureRandom = SecureRandom()
        var newTemp = rand.nextInt(21)+10

        for (t in list){
            t.temperature = newTemp
            listener.onTempChanged(t)
        }
        handler.postDelayed(this::run, 300)
    }
}