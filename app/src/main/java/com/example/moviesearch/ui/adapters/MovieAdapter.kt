package com.example.moviesearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.databinding.ItemMovieBinding
import com.example.moviesearch.domain.Movie

class MovieAdapter(var data: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(newData: List<Movie>) {
        val diffResult = DiffUtil.calculateDiff(MovieDiffUtilCallBack(data, newData))
        diffResult.dispatchUpdatesTo(this)
        data = newData
    }

    class MovieDiffUtilCallBack(private val old: List<Movie>, private val new: List<Movie>) :
        DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return old[oldItemPosition].imdbID == new[newItemPosition].imdbID
        }

        override fun getOldListSize(): Int {
            return old.size
        }

        override fun getNewListSize(): Int {
            return new.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return old[oldItemPosition] == new[newItemPosition]
        }
    }
}