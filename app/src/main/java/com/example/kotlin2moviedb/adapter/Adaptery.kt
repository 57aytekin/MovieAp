package com.example.kotlin2moviedb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2moviedb.R
import com.example.kotlin2moviedb.model.Movie
import com.example.kotlin2moviedb.view.ListFragmentDirections
import kotlinx.android.synthetic.main.row.view.*

class Adaptery (val movies:ArrayList<Movie>):RecyclerView.Adapter<Adaptery.Holder>(){

    class Holder(var view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptery.Holder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Adaptery.Holder, position: Int) {
        holder.view.rowTitle.text=movies.get(position).title
        holder.view.rowRelease.text=movies.get(position).release_date

        holder.itemView.setOnClickListener {
            val action=ListFragmentDirections.actionListFragmentToDetailsFragment(movies.get(position).id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
    fun updateMovieList(newMovieList: List<Movie>) {

        movies.clear()
        movies.addAll(movies)
        notifyDataSetChanged()
    }
}