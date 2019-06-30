package com.project.android.checkpoint.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.project.android.checkpoint.view.ui.BacklogFragment
import com.project.android.checkpoint.view.ui.FinishedFragment
import com.project.android.checkpoint.view.ui.PlayingFragment

class CategoryPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val mTabTitles = arrayOf("BACKLOG", "PLAYING", "FINISHED")

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                BacklogFragment()
            }
            1 -> {
                PlayingFragment()
            }
            else -> {
                FinishedFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTabTitles[position]
    }
}