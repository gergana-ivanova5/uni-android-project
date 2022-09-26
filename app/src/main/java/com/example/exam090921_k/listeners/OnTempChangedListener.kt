package com.example.exam090921_k.listeners

import com.example.exam090921_k.models.Town

interface OnTempChangedListener {
    fun onTempChanged(town: Town)
}