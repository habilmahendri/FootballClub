package com.example.habilmahendri.footballclub.ui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.habilmahendri.footballclub.R
import org.jetbrains.anko.*

class Item_View : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(matchParent, wrapContent)
            orientation = LinearLayout.HORIZONTAL
            padding = dip(5)

            imageView {
                id = R.id.img_view
                imageResource = R.drawable.img_barca
            }.lparams(dip(50), dip(50))

            textView {
                id = R.id.tv_name
                textSize = sp(10).toFloat()
                text = resources.getString(R.string.app_name)
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                leftMargin = dip(7)
            }

        }
    }
}