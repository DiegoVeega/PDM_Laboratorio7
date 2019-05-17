package com.diegoveega.pdm_laboratorio7.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diegoveega.pdm_laboratorio7.database.entities.GitHubRepo


@Dao
interface GithubRepoDAO {

    @Query("SELECT * FROM repos")
    fun getAllRepos():LiveData<List<GitHubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable(){

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GitHubRepo)

}