package com.example.habilmahendri.dicodingfootballclub.ui.detailMatch

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.habilmahendri.dicodingfootballclub.R
import com.example.habilmahendri.dicodingfootballclub.model.Event
import com.example.habilmahendri.dicodingfootballclub.model.Team
import com.example.habilmahendri.dicodingfootballclub.model.repository.MatchRepositoryImpl
import com.example.habilmahendri.dicodingfootballclub.network.ApiInterface
import com.example.habilmahendri.dicodingfootballclub.network.ApiService
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(),DetailContract.View {

    lateinit var mPresenter: DetailPresenter
    private var matchLists:MutableList<Event> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getApi()
    }


    private fun getApi() {
        val service = ApiService.getClient().create(ApiInterface::class.java)
        val request = MatchRepositoryImpl(service)

        val idEvent:String = intent.getStringExtra("idEvent")
        val idAwayTeam:String = intent.getStringExtra("idTeamAway")
        val idHomeTeam:String = intent.getStringExtra("idTeamHome")


        mPresenter = DetailPresenter(this, request)
        mPresenter.getFootbalMatchData(idEvent)
        mPresenter.getTeamBadgeAway(idAwayTeam)
        mPresenter.getTeamBadgeHome(idHomeTeam)

    }


    @SuppressLint("SetTextI18n")
    override fun displayFootballMatch(matchList: Event) {

        tvScoreDetail.text = "${matchList.intAwayScore} vs ${matchList.intHomeScore} "
        tvHomeTeam.text = matchList.strHomeTeam
        tvAwayTeam.text = matchList.strAwayTeam
        tvGoalsAway.text = matchList.strAwayGoalDetails
        tvGoalsHome.text = matchList.strHomeGoalDetails


    }

    override fun displayBadgeTeamHome(team: Team) {
        Glide.with(applicationContext)
                .load(team.strTeamBadge)
                .into(imgHome)

    }

    override fun displayBadgeTeamAway(team: Team) {
        Glide.with(applicationContext)
                .load(team.strTeamBadge)
                .into(imgAway)
    }
}
