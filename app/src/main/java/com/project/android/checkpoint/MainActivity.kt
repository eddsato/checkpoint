package com.project.android.checkpoint

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        val fragmentAdapter = CategoryPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tablayout_main.setupWithViewPager(viewpager_main)
    }
}
