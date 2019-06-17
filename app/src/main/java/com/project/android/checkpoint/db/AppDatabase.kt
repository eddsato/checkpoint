package com.project.android.checkpoint.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.project.android.checkpoint.db.dao.GameDao
import com.project.android.checkpoint.model.Game

@Database(
        version = 3, exportSchema = false, entities = [
            Game::class
        ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase =
                Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java, "app-database"
                ).build()
    }
}