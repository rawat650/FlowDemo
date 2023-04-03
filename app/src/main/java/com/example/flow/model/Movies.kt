package com.example.flow.model


data class Movies(var item: List<MovieData>)
data class MovieData(
    var category: String,
    var imageUrl: String,
    var name: String,
    var desc: String,
)
