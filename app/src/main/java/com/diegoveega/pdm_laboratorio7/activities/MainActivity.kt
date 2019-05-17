package com.diegoveega.pdm_laboratorio7.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.diegoveega.pdm_laboratorio7.R
import com.diegoveega.pdm_laboratorio7.database.entities.GitHubRepo
import com.diegoveega.pdm_laboratorio7.database.viewmodel.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: GithubRepoViewModel
    var cont =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
    }

    private fun bind(){
        viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)

        viewModel.getRepoList().observe(this, Observer{
            //aqui se modifica la lista y se ejecuta el for
            for (i in 0 until it.size){
                Log.d("REpos", it[i].name)
            }
        })

        btn_action.setOnClickListener {
            viewModel.insert(GitHubRepo("Repositorio #" + cont))
            cont++
        }
    }
}
