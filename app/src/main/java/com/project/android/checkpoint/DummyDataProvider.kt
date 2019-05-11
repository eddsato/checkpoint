package com.project.android.checkpoint

object DummyDataProvider {
    fun getDummyGames() = listOf(
            Game("The Witcher 3: Wild Hunt", "Xbox One", "Finished",
                    "Action RPG", "5/5", "02/17/2017", "167h36m"),
            Game("Sekiro: Shadow Die Twice", "Playstation 4", "Playing",
                    "Action RPG", "5/5", "05/11/2019", "67h18m")
    )
}