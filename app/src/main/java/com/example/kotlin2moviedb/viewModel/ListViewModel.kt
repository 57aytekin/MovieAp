package com.example.kotlin2moviedb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin2moviedb.model.Movie
import com.example.kotlin2moviedb.model.MovieResult
import com.example.kotlin2moviedb.servie.MovieApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {
    private val movieApiService = MovieApiService()
    private val compositDisposable = CompositeDisposable()

    val movies = MutableLiveData<MovieResult> ()
    val movieError = MutableLiveData<Boolean>()
    val movieLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        getDataFromAPI()

    }

    private fun getDataFromAPI() {

        movieLoading.value = true  // Kullanıcı sayfa açarken ilk progresBar'ı görmesi için true yapıyoruz

        compositDisposable.add(
            movieApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<MovieResult>(){
                    override fun onSuccess(t: MovieResult) {
                        movies.value=t
                        movieError.value=false
                        movieLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                        movieLoading.value=false
                        movieError.value=true
                        e.printStackTrace()
                    }

                })
        )
    }

}