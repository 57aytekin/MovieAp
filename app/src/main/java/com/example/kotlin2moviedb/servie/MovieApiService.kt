package com.example.kotlin2moviedb.servie

import com.example.kotlin2moviedb.model.Movie
import com.example.kotlin2moviedb.model.MovieResult
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {

    // img url = "https://image.tmdb.org/t/p/w500"      // get = 3/movie/top_rated

    //url = https://api.themoviedb.org/             // api key= a8a0ed30eef769bd3121bd9a495d5a03

    private val BASE_URL = "https://api.themoviedb.org/"

    private val api = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
        .create(MovieApi::class.java)

    fun getData():Single<MovieResult> {
        return api.getMovies("a8a0ed30eef769bd3121bd9a495d5a03")
    }
}