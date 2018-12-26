package com.example.habilmahendri.dicodingfootballclub.base

import com.example.habilmahendri.dicodingfootballclub.model.Event

interface BaseView {

    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<Event>)
    }

    interface Presenter {
        fun getFootbalMatchData()

    }
}