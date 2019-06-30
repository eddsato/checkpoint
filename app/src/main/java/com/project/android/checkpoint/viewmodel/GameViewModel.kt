package com.project.android.checkpoint.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.project.android.checkpoint.service.repository.GameRepository
import com.project.android.checkpoint.service.model.Game

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: GameRepository = GameRepository(application)
    private var backlogGames: LiveData<List<Game>> = repository.getBacklogGames()
    private var playingGames: LiveData<List<Game>> = repository.getPlayingGames()
    private var finishedGames: LiveData<List<Game>> = repository.getFinishedGames()

    fun insert(game: Game) {
        repository.insert(game)
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
}