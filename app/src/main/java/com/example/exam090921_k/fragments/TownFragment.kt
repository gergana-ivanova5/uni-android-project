package com.example.exam090921_k.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.exam090921_k.R
import com.example.exam090921_k.data.StorageData
import com.example.exam090921_k.listeners.OnTownAddListener
import com.example.exam090921_k.models.Town
import com.example.exam090921_k.validators.FormatValidator
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [TownFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TownFragment : DialogFragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
   // private var town: Town? = null
    private lateinit var town:Town
    private lateinit var editText: EditText
    private lateinit var cancel: Button
    private lateinit var save: Button
    private lateinit var listener: OnTownAddListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            town = it.getParcelable(ARG_PARAM1)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_town, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Town) =
            TownFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.editName);
        editText.setText(town.name)

        editText.setOnFocusChangeListener(FormatValidator(Pattern.compile("[A-Z]{4}")))

        cancel = view.findViewById(R.id.buttonCancel)
        save = view.findViewById(R.id.buttonSave)

        save.setOnClickListener(this)
        cancel.setOnClickListener(this)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnTownAddListener){
            listener = context
        }
    }

    override fun onClick(v: View?) {
        var isValid: Boolean = false

        if (v != null) {
            if(v.id == R.id.buttonCancel){
                dismiss()
            }else if(v.id == R.id.buttonSave){
                if(editText.error == null){
                    isValid = true
                }

                if(isValid){
                    town.name = editText.text.toString()
                    town = StorageData.generateTown(town.name)
                    listener.onTownAdd(town)
                    dismiss()
                }
            }
        }
    }
}