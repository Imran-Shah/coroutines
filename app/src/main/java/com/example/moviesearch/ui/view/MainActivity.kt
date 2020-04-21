package com.example.moviesearch.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moviesearch.R
import com.example.moviesearch.databinding.ActivityMainBinding
import com.example.moviesearch.ui.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]

        binding.also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
            it.svMovie.setOnQueryTextListener(this)
        }

        subscribeToError()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            viewModel.search(it)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    private fun subscribeToError() {
        viewModel.error.observe(this, Observer {
            Toast.makeText(baseContext, it, Toast.LENGTH_SHORT).show()
        })
    }
}
