package com.pratima.movietube.model

import com.google.gson.annotations.Expose

data class DataModel(
    @Expose
    var id: Int,
    @Expose
    var title: String,
    @Expose
    var overview: String,
    @Expose
    var results: ArrayList<DataModel>,
    @Expose
    var vote_average: Float,
    @Expose
    var vote_count: Int,
    @Expose
    var popularity: Float,
    @Expose
    var total_results: Int,
    @Expose
    var poster_path: String,
    @Expose
    var backdrop_path: String,
    @Expose
    var original_title: String,
    @Expose
    var original_name: String
) {

}