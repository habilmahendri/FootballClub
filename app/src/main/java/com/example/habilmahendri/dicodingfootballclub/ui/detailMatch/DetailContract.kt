package com.example.habilmahendri.dicodingfootballclub.ui.detailMatch

import com.example.habilmahendri.dicodingfootballclub.model.Event
import com.example.habilmahendri.dicodingfootballclub.model.Team

interface DetailContract {

    interface View {
        fun displayFootballMatch(matchList: Event)
        fun displayBadgeTeamHome(team: Team)
        fun displayBadgeTeamAway(team: Team)

    }


    interface Presenter {
        fun getFootbalMatchData(id: String)
        fun getTeamBadgeHome(id: String)
        fun getTeamBadgeAway(id: String)

    }
}