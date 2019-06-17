package com.project.android.checkpoint.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.android.checkpoint.R
import kotlinx.android.synthetic.main.activity_form_game.*

class FormGameActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_GAME_TITLE = "com.project.android.checkpoint.EXTRA_GAME_TITLE"
        const val EXTRA_PLATAFORM = "com.project.android.checkpoint.PLATAFORM"
        const val EXTRA_GENRE = "com.project.android.checkpoint.GENRE"
        const val EXTRA_STATUS = "com.project.android.checkpoint.STATUS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_game)

        bt_add.setOnClickListener {
            saveGame()
        }
    }

    private fun saveGame() {
        val data = Intent().apply {
            putExtra(EXTRA_GAME_TITLE, et_game_title.text.toString())
            putExtra(EXTRA_PLATAFORM, et_platform.text.toString())
            putExtra(EXTRA_GENRE, et_genre.text.toString())
            putExtra(EXTRA_STATUS, et_status.text.toString())
        }

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
