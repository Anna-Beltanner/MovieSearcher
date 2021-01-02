package com.example.moviesearcher.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.moviesearcher.data.api.TheMovieDBInterface
import com.example.moviesearcher.data.model.MovieDetails
import com.example.moviesearcher.data.repository.MovieDetailsNetworkDataSource
import com.example.moviesearcher.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService: TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails>{

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }
}