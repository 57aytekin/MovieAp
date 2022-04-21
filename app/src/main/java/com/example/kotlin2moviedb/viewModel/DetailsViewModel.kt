package com.example.kotlin2moviedb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin2moviedb.model.Movie

class DetailsViewModel :ViewModel(){

    val detailsMovie=MutableLiveData<Movie>()

    fun getDataDetails() {
        val detailsmovie=Movie("1","1","1","1",)

        detailsMovie.value=detailsmovie
    }

}