package com.diegoveega.pdm_laboratorio7.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.diegoveega.pdm_laboratorio7.database.RoomDB
import com.diegoveega.pdm_laboratorio7.database.entities.GitHubRepo
import com.diegoveega.pdm_laboratorio7.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app) {

    private val repository:GithubRepoRepository

    init {
        //se ejecuta despues de la llamada del constructor
        val repoDAO = RoomDB.getInstance(app).repoDao()
        //link con base de datos

        repository = GithubRepoRepository(repoDAO)
    }

    fun getRepoList():LiveData<List<GitHubRepo>> = repository.getAll()

    fun insert(repo: GitHubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

}