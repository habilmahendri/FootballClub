package com.example.habilmahendri.footballclub.ui

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.habilmahendri.footballclub.MainActivity.Companion.items
import com.example.habilmahendri.footballclub.R
import com.example.habilmahendri.footballclub.activity.DetailActivity
import com.example.habilmahendri.footballclub.model.Item
import org.jetbrains.anko.*

class Detail_View(var item:Item) : AnkoComponent<DetailActivity> {
    override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui){
        linearLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            orientation = LinearLayout.VERTICAL

            imageView {
                id = R.id.detail_image
                Glide.with(this).load(item.image).into(this)
                imageResource = R.drawable.img_barca
            }.lparams(dip(50),dip(50))

            textView {
                id = R.id.detail_name

                text = item.name
            }.lparams(wrapContent, wrapContent)

            textView {
                id = R.id.detail_content
                text = item.content
            }.lparams(wrapContent, wrapContent){
                topMargin = dip(10)
            }
        }
    }

}