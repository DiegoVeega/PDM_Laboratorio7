package com.diegoveega.pdm_laboratorio7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diegoveega.pdm_laboratorio7.database.dao.GithubRepoDAO
import com.diegoveega.pdm_laboratorio7.database.entities.GitHubRepo

//entidades que posea

@Database(entities = [GitHubRepo::class], version = 1,exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun repoDao():GithubRepoDAO

    companion object {
        @Volatile
        private var INSTANCE:RoomDB? = null

        fun getInstance(AppContext: Context):RoomDB{
            val temp = INSTANCE

            if(temp!=null){
                return temp
            }
            synchronized(this){
                val instance = Room.databaseBuilder(AppContext,RoomDB::class.java,"RepoDB").build()

                INSTANCE = instance
                return instance
            }
        }
    }
}