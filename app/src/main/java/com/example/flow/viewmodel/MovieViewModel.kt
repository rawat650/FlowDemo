package com.example.flow.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow.MovieRepository
import com.example.flow.model.MovieData
import com.example.flow.model.Movies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieViewModel(val movieRepository: MovieRepository):ViewModel() {
    val _movieLiveData = MutableLiveData<List<MovieData>>()
    val movieResponse: LiveData<List<MovieData>> = _movieLiveData
     fun getMovie() {
         viewModelScope.launch {
             movieRepository.getMovie().collect {
                 _movieLiveData.postValue(it)

             }
         }
         Log.d("movieData",_movieLiveData.toString())

     }}