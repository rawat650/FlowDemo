package com.example.flow

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flow.databinding.ActivityMainBinding
import com.example.flow.model.MovieData
import com.example.flow.model.Movies
import com.example.flow.network.ApiService
import com.example.flow.view.adapter.MovieAdapter
import com.example.flow.viewmodel.MovieViewModel
import com.example.flow.viewmodel.MoviesFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel:MovieViewModel
    lateinit var adapter: MovieAdapter
    lateinit var recView:RecyclerView
    val apiService = ApiService.getInstance()
val movieData:ArrayList<MovieData> = ArrayList()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MovieAdapter(movieData,this)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = adapter
        viewmodel = ViewModelProvider(this,MoviesFactory(MovieRepository(apiService))).get(MovieViewModel::class.java)


        viewmodel.movieResponse.observe(this, Observer {
            movieData.addAll(it)
            adapter.notifyDataSetChanged()

        })
        viewmodel.getMovie()

    }






}