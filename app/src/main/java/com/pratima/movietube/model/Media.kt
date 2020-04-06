package com.pratima.movietube.model

import kotlinx.serialization.Serializable

@Serializable
data class Media constructor(
    var id: Int = 0,
    var title: String = "",
    var overview: String = "",
    var results: ArrayList<Media> = arrayListOf(),
    var vote_average: Float = 0.0f,
    var vote_count: Int = 0,
    var popularity: Float = 0.0f,
    var total_results: Int = 0,
    var poster_path: String = "",
    var backdrop_path: String = "",
    var original_title: String = "",
    var original_name: String = ""
)