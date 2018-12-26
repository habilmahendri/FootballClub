package com.example.habilmahendri.dicodingfootballclub.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.habilmahendri.dicodingfootballclub.ui.LastMatch.LastFragment
import com.example.habilmahendri.dicodingfootballclub.ui.UpComingMatch.UpComingFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LastFragment()
            }else ->{
              return UpComingFragment()

            }

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Last Match"
            else ->{
                return "UpComing Match"
            }

        }
    }

}