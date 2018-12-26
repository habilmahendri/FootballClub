package com.example.habilmahendri.dicodingfootballclub.model

import com.google.gson.annotations.SerializedName

data class ResponseEvents(
        @SerializedName("events") var events: List<Event>)
