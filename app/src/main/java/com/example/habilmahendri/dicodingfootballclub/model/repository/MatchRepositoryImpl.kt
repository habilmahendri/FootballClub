package com.example.habilmahendri.dicodingfootballclub.model.repository

import com.example.habilmahendri.dicodingfootballclub.model.ResponseEvents
import com.example.habilmahendri.dicodingfootballclub.model.ResponseTeams
import com.example.habilmahendri.dicodingfootballclub.network.ApiInterface
import io.reactivex.Flowable

class MatchRepositoryImpl(private val apiInterface: ApiInterface) : MatchRepository {
    override fun getDetailMatch(id: String): Flowable<ResponseEvents> = apiInterface.getDetailMatch(id)

    override fun getUpcomingMatch(id: String): Flowable<ResponseEvents> = apiInterface.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<ResponseEvents> = apiInterface.getLastMatch(id)

    override fun getTeamAway(id: String): Flowable<ResponseTeams> = apiInterface.getTeams(id)

    override fun getTeamHome(id: String): Flowable<ResponseTeams> = apiInterface.getTeams(id)

}