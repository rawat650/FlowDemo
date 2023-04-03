package com.example.flow.view.adapter

import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flow.databinding.MovieViewBinding
import com.example.flow.model.MovieData
import com.example.flow.model.Movies

class MovieAdapter(val movieList: List<MovieData>,val context:Context):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    class MovieViewHolder(val binding: MovieViewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
     return MovieViewHolder(MovieViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
      val movieData = movieList[position]
        holder.binding.txtName.text= movieData.name
        Glide.with(context).load(movieData.imageUrl).into(holder.binding.imgMovie)
    }

    override fun getItemCount(): Int {
        if(movieList==null) return 0;
        return movieList.size
    }
}