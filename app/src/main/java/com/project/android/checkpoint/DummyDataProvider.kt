package com.project.android.checkpoint

object DummyDataProvider {
    fun getDummyGames() = listOf(
            Game("The Witcher 3: Wild Hunt", "Playstation 4", "Finished",
                    "Action RPG"),
            Game("Spider-man", "Playstation 4", "Backlog",
                    "Action"),
            Game("Sekiro: Shadow Die Twice", "Playstation 4", "Playing",
                    "Action RPG")
    )
}