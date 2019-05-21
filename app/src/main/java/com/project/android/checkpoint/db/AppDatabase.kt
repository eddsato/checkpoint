package com.project.android.checkpoint.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.project.android.checkpoint.db.dao.GameDao
import com.project.android.checkpoint.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao
}