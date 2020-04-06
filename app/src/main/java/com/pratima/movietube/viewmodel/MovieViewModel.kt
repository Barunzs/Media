package com.pratima.movietube.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.pratima.movietube.api.ApiConstants
import com.pratima.movietube.model.DataModel
import com.pratima.movietube.repository.DataRepository

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    var popularMovieLiveData: LiveData<DataModel>?
    private val TAG: String = "SearchViewModel"
    var searchResponse: LiveData<DataModel>?

    init {
        searchResponse = null
        val movieRepository = DataRepository()
        popularMovieLiveData = movieRepository.getMovies(
            ApiConstants.POPULAR_DESC,
            ApiConstants.API_KEY

        )
    }

    fun setSearchQuery(query: String) {
        val searchRepository = DataRepository()
        if (query.isNotEmpty()) {
            searchResponse = searchRepository.getSearchResult(query, ApiConstants.API_KEY)
        }
    }
}