package com.example.habilmahendri.footballclub.ui

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.example.habilmahendri.footballclub.MainActivity
import com.example.habilmahendri.footballclub.MainActivity.Companion.items
import com.example.habilmahendri.footballclub.R
import com.example.habilmahendri.footballclub.activity.DetailActivity
import com.example.habilmahendri.footballclub.adapter.RecyclerviewAdapter
import com.example.habilmahendri.footballclub.model.Constant
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class Main_View : AnkoComponent<MainActivity>{
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        linearLayout{
            lparams(matchParent, matchParent)
            recyclerView {
                id = R.id.club_list_id
                layoutManager = LinearLayoutManager(context)
                adapter = RecyclerviewAdapter(context, items) {
                    startActivity<DetailActivity>(Constant.EXTRA_CONTENT.name to it)
                }
            }
        }
    }

}