package com.example.habilmahendri.footballclub.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val name: String?, val image: Int?, val content: String?) : Parcelable