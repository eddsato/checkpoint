package com.project.android.checkpoint.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.project.android.checkpoint.repository.GameRepository

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: GameRepository = GameRepository(application)
    private var allGames: LiveData<List<Game>> = repository.getAllGames()

    fun insert(game: Game) {
        repository.insert(game)
    }

    fun getAllGames(): LiveData<List<Game>> {
        return allGames
    }
}