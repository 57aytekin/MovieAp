package com.example.kotlin2moviedb.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("release_date")
    val release_date: String?,
    @SerializedName("poster_path")
    val poster_path: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}

data class MovieResult(val results: ArrayList<Movie>)


