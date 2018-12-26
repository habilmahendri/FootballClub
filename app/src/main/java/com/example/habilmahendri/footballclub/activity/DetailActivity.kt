package com.example.habilmahendri.footballclub.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.habilmahendri.footballclub.R
import com.example.habilmahendri.footballclub.model.Constant
import com.example.habilmahendri.footballclub.model.Item
import com.example.habilmahendri.footballclub.ui.Detail_View
import org.jetbrains.anko.setContentView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val intent = intent
        val item = intent.getParcelableExtra<Item>(Constant.EXTRA_CONTENT.name)
        Detail_View(item).setContentView(this)


    }
}
