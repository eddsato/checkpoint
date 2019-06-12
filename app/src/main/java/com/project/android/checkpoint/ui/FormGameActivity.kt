package com.project.android.checkpoint.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.android.checkpoint.R
import com.project.android.checkpoint.db.AppDatabase
import com.project.android.checkpoint.db.dao.GameDao
import com.project.android.checkpoint.model.Game
import kotlinx.android.synthetic.main.activity_form_game.*
import kotlin.concurrent.thread

class FormGameActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var gameDao: GameDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_game)

        database = AppDatabase.getInstance(this)
        gameDao = database.gameDao()

        bt_add.setOnClickListener {
            addGame()
            cleanForm()
        }
    }

    private fun addGame() {
        val gameTitle = et_game_title.text.toString()
        val plataform = et_platform.text.toString()
        val genre = et_genre.text.toString()
        val playingStatus = et_playing_status.text.toString()

        if (title.isBlank()) {
            //Snackbar
        }

        val game = Game(
                gameTitle = gameTitle,
                plataform = plataform,
                genre = genre,
                playingStatus = playingStatus)

        thread { gameDao.insert(game) }
    }

    private fun cleanForm() {
        et_game_title.setText("")
        et_genre.setText("")
        et_platform.setText("")
        et_playing_status.setText("")
    }
}
