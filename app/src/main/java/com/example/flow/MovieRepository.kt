package com.example.flow

import com.example.flow.model.MovieData
import com.example.flow.model.Movies
import com.example.flow.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository(val apiService: ApiService) {
     fun getMovie():Flow<List<MovieData>>{
        return flow<List<MovieData>> {
            apiService.getMovie().body()?.let { emit(it) }
        }
    }
}