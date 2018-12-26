package com.example.habilmahendri.dicodingfootballclub.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.habilmahendri.dicodingfootballclub.R
import com.example.habilmahendri.dicodingfootballclub.model.Event
import com.example.habilmahendri.dicodingfootballclub.ui.detailMatch.DetailActivity
import kotlinx.android.synthetic.main.list_item.view.*
import org.jetbrains.anko.startActivity

class BaseAdapter(
        val eventList: List<Event>,
        val context: Context?) : RecyclerView.Adapter<BaseAdapter.FootBallViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootBallViewHolder {
        return FootBallViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: FootBallViewHolder, position: Int) = holder.bind(eventList[position])


    class FootBallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Event) {


            itemView.tvDate.text = event.dateEvent
            itemView.tvAwayTeam.text = event.strAwayTeam
            itemView.tvHomeTeam.text = event.strHomeTeam



            if (event.intAwayScore != null && event.intHomeScore != null) {
                var score: String? = "${event.intAwayScore} VS ${event.intHomeScore}"
                itemView.tvScore.text = score
            } else {
                itemView.tvScore.text = " VS "
            }

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>(
                        "idEvent" to event.idEvent,
                        "idTeamHome" to event.idHomeTeam,
                        "idTeamAway" to event.idAwayTeam
                        )
            }

        }


    }


}