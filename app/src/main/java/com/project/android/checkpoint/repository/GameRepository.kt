package com.project.android.checkpoint.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.project.android.checkpoint.db.AppDatabase
import com.project.android.checkpoint.db.dao.GameDao
import com.project.android.checkpoint.model.Game

class GameRepository(application: Application) {
    private var gameDao: GameDao
    private var allGames: LiveData<List<Game>>

    init {
        val database: AppDatabase = AppDatabase.getInstance(
                application.applicationContext
        )!!
        gameDao = database.gameDao()
        allGames = gameDao.getAll()
    }

    fun getAllGames(): LiveData<List<Game>> {
        return allGames
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