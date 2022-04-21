package com.example.kotlin2moviedb.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin2moviedb.R
import com.example.kotlin2moviedb.adapter.Adaptery
import com.example.kotlin2moviedb.model.Movie
import com.example.kotlin2moviedb.model.MovieResult
import com.example.kotlin2moviedb.viewModel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private lateinit var adaptery: Adaptery
    private lateinit var movie: List<Movie>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel= ViewModelProvider(this).get(ListViewModel::class.java)
        movie = listOf()

        viewModel.refreshData()
            //Recyclerview
        recyclerView.layoutManager=LinearLayoutManager(context)
        adaptery= Adaptery(arrayListOf())
        recyclerView.adapter=adaptery

        observeLiveData()
    }

    private fun observeLiveData() {

        viewModel.movies.observe(viewLifecycleOwner, Observer {movies  ->

            movies?.let {
                recyclerView.visibility=View.VISIBLE
                adaptery.updateMovieList(movies.results)

            }

        })

        viewModel.movieLoading.observe(viewLifecycleOwner, Observer { loading ->

            loading?.let {
                if (it) {
                        //FragmentList xml içerisindeki id'ler aşağıdadır
                    movieLoading.visibility=View.VISIBLE
                    movieError.visibility=View.GONE
                    recyclerView.visibility=View.GONE
                } else {
                    movieLoading.visibility=View.GONE
                }
            }
        })

        viewModel.movieError.observe(viewLifecycleOwner, Observer { error ->

            error?.let {
                if (it) {
                    movieError.visibility=View.VISIBLE
                } else {
                    movieError.visibility=View.GONE
                }
            }
        })
    }

}