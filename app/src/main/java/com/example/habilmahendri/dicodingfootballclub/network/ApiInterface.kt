package com.example.habilmahendri.dicodingfootballclub.network

import com.example.habilmahendri.dicodingfootballclub.model.ResponseEvents
import com.example.habilmahendri.dicodingfootballclub.model.ResponseTeams
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("eventspastleague.php")
    fun getLastMatch(@Query("id") id: String): Flowable<ResponseEvents>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id: String): Flowable<ResponseEvents>

    @GET("lookupevent.php")
    fun getDetailMatch(@Query("id") id: String): Flowable<ResponseEvents>

    @GET("lookupteam.php")
    fun getTeams(@Query("id")id:String):Flowable<ResponseTeams>


}
