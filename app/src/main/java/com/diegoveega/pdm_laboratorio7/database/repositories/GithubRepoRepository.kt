package com.diegoveega.pdm_laboratorio7.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.diegoveega.pdm_laboratorio7.database.dao.GithubRepoDAO
import com.diegoveega.pdm_laboratorio7.database.entities.GitHubRepo


class GithubRepoRepository(private val repoDAO: GithubRepoDAO) {

    //obtener todos
    fun getAll():LiveData<List<GitHubRepo>> = repoDAO.getAllRepos()


    //borrar tabla

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo: GitHubRepo) = repoDAO.insert(repo)

}