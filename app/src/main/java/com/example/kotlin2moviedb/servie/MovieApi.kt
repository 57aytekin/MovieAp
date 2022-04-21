package com.example.kotlin2moviedb.servie

import com.example.kotlin2moviedb.model.Movie
import com.example.kotlin2moviedb.model.MovieResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    //https://jsonplaceholder.typicode.com/       photos

    // img url = "https://image.tmdb.org/t/p/w500"      // get = 3/movie/top_rated

    //url = https://api.themoviedb.org/             // api key= a8a0ed30eef769bd3121bd9a495d5a03


    @GET("3/movie/top_rated")
    fun getMovies(
        @Query("api_key") apikey:String
    ): Single<MovieResult>
}