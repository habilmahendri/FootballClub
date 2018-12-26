package com.example.habilmahendri.dicodingfootballclub.model.repository

import com.example.habilmahendri.dicodingfootballclub.model.ResponseEvents
import com.example.habilmahendri.dicodingfootballclub.model.ResponseTeams
import io.reactivex.Flowable

interface MatchRepository {
    fun getFootballMatch(id:String):Flowable<ResponseEvents>
    fun getUpcomingMatch(id : String) : Flowable<ResponseEvents>
    fun getDetailMatch(id:String):Flowable<ResponseEvents>
    fun getTeamHome(id: String): Flowable<ResponseTeams>
    fun getTeamAway(id: String): Flowable<ResponseTeams>



}