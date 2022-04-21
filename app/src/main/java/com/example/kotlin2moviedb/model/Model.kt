package com.example.kotlin2moviedb.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val title: String?,
    @SerializedName("title")
    val overview: String?,
    @SerializedName("title")
    val release_date: String?,
    @SerializedName("title")
    val poster_path: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}

data class MovieResult(val results: ArrayList<Movie>)


