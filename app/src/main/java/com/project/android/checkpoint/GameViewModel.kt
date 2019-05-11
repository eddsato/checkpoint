package com.project.android.checkpoint

import android.arch.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    fun getGames() = DummyDataProvider.getDummyGames()
}