package com.diegoveega.pdm_laboratorio7.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//no solo una database sino tambien una entidad dentro de la base de datos
@Entity(tableName = "repos")
data class GitHubRepo(
    @ColumnInfo(name = "s_name")

    val name:String

) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}