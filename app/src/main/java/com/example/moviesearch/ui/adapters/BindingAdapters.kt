package com.example.moviesearch.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesearch.domain.Movie

@BindingAdapter("data")
fun loadData(recyclerView: RecyclerView, data: List<Movie>) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = MovieAdapter(data)
    } else {
        (recyclerView.adapter as MovieAdapter).updateData(data)
    }

}

@BindingAdapter("url")
fun loadImage(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView.context)
            .load(it)
            .into(imageView)
    }

}