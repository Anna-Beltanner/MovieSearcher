package com.example.moviesearcher.ui.single_movie_details
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearcher.data.model.MovieDetails
import com.example.moviesearcher.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable


class SingleMovieViewModel(private val movieRepository: MovieDetailsRepository, movieId: Int): ViewModel() {

private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}