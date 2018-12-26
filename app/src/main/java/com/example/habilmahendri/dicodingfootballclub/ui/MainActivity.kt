package com.example.habilmahendri.dicodingfootballclub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.habilmahendri.dicodingfootballclub.R
import com.example.habilmahendri.dicodingfootballclub.adapter.MyPagerAdapter
import com.example.habilmahendri.dicodingfootballclub.model.Event
import com.example.habilmahendri.dicodingfootballclub.ui.LastMatch.LastPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewPager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewPager_main)



    }

}
