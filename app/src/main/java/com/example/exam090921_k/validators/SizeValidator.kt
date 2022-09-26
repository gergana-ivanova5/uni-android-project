package com.example.exam090921_k.validators

import android.view.View
import android.widget.EditText

class SizeValidator(min: Int): View.OnFocusChangeListener {

    private var min: Int = 0

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        var editText: EditText = v as EditText

        if(editText.text.toString().length<min){
            editText.setError("Invalid text size!")
        }
    }
}