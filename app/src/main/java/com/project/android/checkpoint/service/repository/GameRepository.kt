package com.project.android.checkpoint.service.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.project.android.checkpoint.service.db.AppDatabase
import com.project.android.checkpoint.service.db.dao.GameDao
import com.project.android.checkpoint.service.model.Game

class GameRepository(application: Application) {
    private val BACKLOG_STATUS = "Backlog"
    private val PLAYING_STATUS = "Playing"
    private val FINISHED_STATUS = "Finished"

    private var gameDao: GameDao
    private var backlogGames: LiveData<List<Game>>
    private var playingGames: LiveData<List<Game>>
    private var finishedGames: LiveData<List<Game>>

    init {
        val database: AppDatabase = AppDatabase.getInstance(
                application.applicationContext
        )!!
        gameDao = database.gameDao()
        backlogGames = gameDao.getBacklogGames(BACKLOG_STATUS)
        playingGames = gameDao.getPlayingGames(PLAYING_STATUS)
        finishedGames = gameDao.getFinishedGames(FINISHED_STATUS)
    }

    fun getBacklogGames(): LiveData<List<Game>> {
        return backlogGames
    }

    fun getPlayingGames(): LiveData<List<Game>> {
        return playingGames
    }

    fun getFinishedGames(): LiveData<List<Game>> {
        return finishedGames
    }

    fun insert(game: Game) {
        InsertGameAsyncTask(gameDao).execute(game)
    }

    private class InsertGameAsyncTask(gameDao: GameDao) : AsyncTask<Game, Unit, Unit>() {
        val gameDao = gameDao

        override fun doInBackground(vararg p0: Game?) {
            gameDao.insert(p0[0]!!)
        }
    }
}