package com.preeliminatorylabs.novie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.preeliminatorylabs.novie.R
import com.preeliminatorylabs.novie.model.Movie

class UpcomingMovieAdapter(val movieList: List<Movie>, val context: Context) : RecyclerView.Adapter<UpcomingMovieAdapter.ViewHolder>() {

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_movie_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(BASE_IMG_URL + movieList[position].image).into(holder.image)
        holder.title.text = movieList[position].title
        holder.language.text = movieList[position].language
        holder.release.text = movieList[position].release_date
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.imvPosterPath)
        val title = itemView.findViewById<TextView>(R.id.txtTitle)
        val language = itemView.findViewById<TextView>(R.id.txtOriginalLanguage)
        val release = itemView.findViewById<TextView>(R.id.txtReleaseDate)
    }
}