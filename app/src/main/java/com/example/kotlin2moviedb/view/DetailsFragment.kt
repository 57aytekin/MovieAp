package com.example.kotlin2moviedb.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin2moviedb.R
import com.example.kotlin2moviedb.viewModel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private lateinit var viewModel:DetailsViewModel
    private var movieId=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            movieId=DetailsFragmentArgs.fromBundle(it).uuid
        }

        viewModel=ViewModelProvider(this).get(DetailsViewModel::class.java)

        viewModel.getDataDetails()

        observleLiveData()
    }
    private  fun observleLiveData() {

        viewModel.detailsMovie.observe(viewLifecycleOwner, Observer { movie ->
            movie?.let {

                titleDetails.text=movie.title
                overviewDetails.text=movie.overview
                releaseDetails.text=movie.release_date
            }
        })
    }

}