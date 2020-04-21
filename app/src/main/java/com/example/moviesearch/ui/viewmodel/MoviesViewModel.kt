package com.example.moviesearch.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearch.data.Repository
import com.example.moviesearch.domain.Movie
import kotlinx.coroutines.*

const val API_KEY = "586573af"
const val PAGE_NO = 1

class MoviesViewModel : ViewModel() {

    val data = MutableLiveData<List<Movie>>().also {
        it.value = listOf()
    }

    val error = MutableLiveData<String>()

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        error.value = throwable.message

    }

    private val repository = Repository()

    fun search(movie: String) {

        scope.launch(exceptionHandler) {
            repository.getMovies(
                API_KEY, movie,
                PAGE_NO
            ).let {
                if (it.Search.isNullOrEmpty()) error.value = "No movie found"
                else data.value = it.Search
            }
        }

    }

    override fun onCleared() {
        scope.cancel()
        super.onCleared()
    }
}