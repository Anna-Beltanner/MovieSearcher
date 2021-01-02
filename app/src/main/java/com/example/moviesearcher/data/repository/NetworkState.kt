package com.example.moviesearcher.data.repository

import com.example.moviesearcher.data.repository.NetworkState.Companion.LOADING

enum class Status{
    RUNNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg: String) {

    companion object{

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val END_OF_LIST: NetworkState

        init {

            LOADED = NetworkState(Status.SUCCESS, "Success")
            LOADING = NetworkState(Status.RUNNNING, "Running")
            ERROR = NetworkState(Status.FAILED, "OOPS! Something is wrong")
            END_OF_LIST = NetworkState(Status.FAILED, "You have reached the end of the list")
        }
    }
}