package com.example.habilmahendri.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.habilmahendri.footballclub.model.Item
import com.example.habilmahendri.footballclub.ui.Main_View
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    companion object {
        var items:MutableList<Item> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Main_View().setContentView(this)
        initView()
    }

    private fun initView() {
        val nameClub = resources.getStringArray(R.array.club_name)
        val imageClub = resources.obtainTypedArray(R.array.club_image)
        val contentClub = resources.getStringArray(R.array.club_content)

        items.clear()
        for (i in nameClub.indices) {
            items.add(Item(nameClub[i], imageClub.getResourceId(i, 0), contentClub[i]))


        }
        imageClub.recycle()
    }
}
