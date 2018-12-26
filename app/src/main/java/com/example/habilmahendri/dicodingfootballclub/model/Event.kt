package com.example.habilmahendri.dicodingfootballclub.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
        @SerializedName("strHomeTeam")var strHomeTeam:String?,
        @SerializedName("strAwayTeam")var strAwayTeam:String?,
        @SerializedName("dateEvent")var dateEvent:String?,
        @SerializedName("intHomeScore")var intHomeScore:String?,
        @SerializedName("intAwayScore")var intAwayScore:String?,
        @SerializedName("idEvent")var idEvent:String,
        @SerializedName("idAwayTeam")var idAwayTeam:String,
        @SerializedName("idHomeTeam")var idHomeTeam:String,
        @SerializedName("strHomeFormation")var strHomeFormation:String?,
        @SerializedName("strHomeGoalDetails")var strHomeGoalDetails:String?,
        @SerializedName("strAwayGoalDetails")var strAwayGoalDetails:String?,
        @SerializedName("intHomeShots")var intHomeShots:String?,
        @SerializedName("intAwayShots")var intAwayShots:String?
):Parcelable