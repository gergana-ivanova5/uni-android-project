package com.example.exam090921_k.models

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
class Town(var name:String, var temperature:Int) : Parcelable {
  //  private var name: String = _name
  //  get() = field
  //  set(value){ field = value}
   // private var temperature: Int= _temperature
    //get() = field
 //   set(value){ field = value}
}