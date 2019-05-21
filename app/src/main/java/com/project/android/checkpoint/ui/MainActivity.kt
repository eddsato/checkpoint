package com.project.android.checkpoint.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.project.android.checkpoint.R
import com.project.android.checkpoint.adapter.CategoryPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        fab_add.setOnClickListener {
            val intent = Intent(this, FormGameActivity::class.java)
            startActivity(intent)
        }

        val fragmentAdapter = CategoryPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tablayout_main.setupWithViewPager(viewpager_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
