package com.example.habilmahendri.dicodingfootballclub.ui.LastMatch


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




class LastFragment : Fragment(), BaseView.View {

    lateinit var mPresenter: LastPresenter
    private var matchLists: MutableList<Event> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val service = ApiService.getClient().create(ApiInterface::class.java)
        val request = MatchRepositoryImpl(service)
        mPresenter = LastPresenter(this, request)
        mPresenter.getFootbalMatchData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last, container, false)
    }

    override fun hideLoading() {
        pgLast.hide()
    }

    override fun showLoading() {
        pgLast.show()
    }

    override fun displayFootballMatch(matchList: List<Event>) {

        Log.v("test", "" + matchList.size)
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = BaseAdapter(matchList, context)
        for (i in matchList.indices) {
            Log.v("test", "" + matchList.get(i).dateEvent)

        }
    }


}
