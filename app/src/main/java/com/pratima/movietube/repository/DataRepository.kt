package com.pratima.movietube.repository

import androidx.lifecycle.LiveData
import com.pratima.movietube.api.ApiRequest
import com.pratima.movietube.api.RetrofitRequest
import com.pratima.movietube.model.DataModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class DataRepository {

    private var apiRequest: ApiRequest? = null
    private val TAG = DataRepository::class.java.simpleName
    var job: CompletableJob? = null

    init {
        apiRequest = RetrofitRequest.retrofitInstance!!.create(ApiRequest::class.java)
    }

    fun getPopularTvShows(query: String, key: String): LiveData<DataModel> {
        job = Job()
        return object : LiveData<DataModel>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val user = apiRequest?.getPopularTvShows(query, key)
                        withContext(Main) {
                            value = user
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }

    fun getSearchResult(query: String, key: String): LiveData<DataModel> {
        job = Job()
        return object : LiveData<DataModel>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val user = apiRequest?.getMovieSearchResult(query, key)
                        withContext(Main) {
                            value = user
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }

    fun getMovies(query: String, key: String): LiveData<DataModel> {
        job = Job()
        return object : LiveData<DataModel>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val user = apiRequest?.getPopularMovies(query, key)
                        withContext(Main) {
                            value = user
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }
}