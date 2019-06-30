package com.project.android.checkpoint.view.ui

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.Toast
import com.project.android.checkpoint.R
import com.project.android.checkpoint.service.model.Game
import com.project.android.checkpoint.view.adapter.CategoryPagerAdapter
import com.project.android.checkpoint.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val ADD_GAME_REQUEST = 1
    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        fab_add.setOnClickListener {
            startActivityForResult(
                    Intent(this, FormGameActivity::class.java),
                    ADD_GAME_REQUEST
            )
        }

        val fragmentAdapter = CategoryPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tablayout_main.setupWithViewPager(viewpager_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        if (requestCode == ADD_GAME_REQUEST && resultCode == Activity.RESULT_OK) {
            val newGame = Game(
                    data!!.getStringExtra(FormGameActivity.EXTRA_GAME_TITLE),
                    data.getStringExtra(FormGameActivity.EXTRA_PLATAFORM),
                    data.getStringExtra(FormGameActivity.EXTRA_GENRE),
                    data.getStringExtra(FormGameActivity.EXTRA_STATUS)
            )
            gameViewModel.insert(newGame)

            Toast.makeText(this, "Game saved!", Toast.LENGTH_SHORT).show()
        }
    }
}
