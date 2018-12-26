package com.example.habilmahendri.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ScrollingTabContainerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.habilmahendri.footballclub.R
import com.example.habilmahendri.footballclub.model.Item
import com.example.habilmahendri.footballclub.ui.Item_View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.notification_template_lines_media.*
import org.jetbrains.anko.AnkoContext

class RecyclerviewAdapter(
        private val context: Context,
        private val items: List<Item>,
        private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(Item_View().createView(AnkoContext.create(context, parent)), null)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(items[position], listener)


    class ViewHolder(view: View, override val containerView: View?) : RecyclerView.ViewHolder(view), LayoutContainer {

        val clubName = itemView.findViewById<TextView>(R.id.tv_name)
        val clubImage = itemView.findViewById<ImageView>(R.id.img_view)


        fun bindItem(items: Item, listener: (Item) -> Unit) {
            clubName.text = items.name
            Glide.with(itemView.context).load(items.image).into(clubImage)
            itemView.setOnClickListener {
                listener(items)
            }

        }

    }
}