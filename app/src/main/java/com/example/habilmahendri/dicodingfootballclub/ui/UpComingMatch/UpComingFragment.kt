package com.example.habilmahendri.dicodingfootballclub.ui.UpComingMatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.habilmahendri.dicodingfootballclub.R
import com.example.habilmahendri.dicodingfootballclub.adapter.BaseAdapter
import com.example.habilmahendri.dicodingfootballclub.base.BaseView
import com.example.habilmahendri.dicodingfootballclub.model.Event
import com.example.habilmahendri.dicodingfootballclub.model.repository.MatchRepositoryImpl
import com.example.habilmahendri.dicodingfootballclub.network.ApiInterface
import com.example.habilmahendri.dicodingfootballclub.network.ApiService
import com.example.habilmahendri.dicodingfootballclub.util.hide
import com.example.habilmahendri.dicodingfootballclub.util.show
import kotlinx.android.synthetic.main.fragment_last.*
import kotlinx.android.synthetic.main.fragment_up_coming.*


class UpComingFragment : Fragment(),BaseView.View {

    lateinit var mPresenter: UpComingPresenter
    private var matchLists:MutableList<Event> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        callApi()


    }

    fun callApi() {
        val service = ApiService.getClient().create(ApiInterface::class.java)
        val request = MatchRepositoryImpl(service)
        mPresenter = UpComingPresenter(this, request)
        mPresenter.getFootbalMatchData()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_up_coming, container, false)
    }

    override fun hideLoading() {
        pgUpComing.hide()
    }

    override fun showLoading() {
        pgUpComing.show()
    }

    override fun displayFootballMatch(matchList: List<Event>) {
        Log.v("upcoming", "" + matchList.size)
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvUpComing.layoutManager = layoutManager
        rvUpComing.adapter = BaseAdapter(matchList,context)


    }



}
