package com.pratima.movietube.api

import com.pratima.movietube.model.Media
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {

    @GET("3/discover/movie/")
    suspend fun getPopularMovies(
        @Query("page") query: String?,
        @Query("api_key") apiKey: String?
    ): Media


    @GET("3/discover/tv/")
    suspend fun getPopularTvShows(
        @Query("sort_by") query: String?,
        @Query("api_key") apiKey: String?
    ): Media


    @GET("3/search/movie/")
   suspend fun getMovieSearchResult(
        @Query("query") query: String?,
        @Query("api_key") apiKey: String?
    ): Media
}