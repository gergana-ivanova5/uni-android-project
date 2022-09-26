package com.example.exam090921_k.validators

import android.view.View
import android.widget.EditText
import java.util.regex.Pattern

class FormatValidator(pattern: Pattern): View.OnFocusChangeListener{

    private lateinit var pattern: Pattern

    init {
        this.pattern = pattern
    }
    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        var editText: EditText = v as EditText

        if(!pattern.matcher(editText.text).matches()){
            editText.setError("Invalid Format!")
        }

    }
}