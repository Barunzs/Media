package com.pratima.movietube.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.pratima.movietube.api.ApiRequest
import com.pratima.movietube.api.RetrofitRequest
import com.pratima.movietube.model.Media
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonParsingException

class DataRepository {

    private var apiRequest: ApiRequest? = null
    private val TAG = DataRepository::class.java.simpleName
    var job: CompletableJob? = null

    init {
        apiRequest = RetrofitRequest.retrofitInstance!!.create(ApiRequest::class.java)
    }

    fun getPopularTvShows(query: String, key: String): LiveData<Media> {
        job = Job()
        return object : LiveData<Media>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        try {
                            val user = apiRequest?.getPopularTvShows(query, key)
                            withContext(Main) {
                                value = user
                                theJob.complete()
                            }
                        } catch (ex: JsonParsingException) {
                            Log.d("TAG", "getPopularTvShows JsonParsingException${ex.message}")
                        }

                    }

                }

            }
        }
    }

    fun getSearchResult(query: String, key: String): LiveData<Media> {
        job = Job()
        return object : LiveData<Media>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        try {
                            val user = apiRequest?.getMovieSearchResult(query, key)
                            withContext(Main) {
                                value = user
                                theJob.complete()
                            }
                        } catch (ex: JsonParsingException) {
                            Log.d("TAG", "getSearchResult JsonParsingException${ex.message}")
                        }

                    }

                }

            }
        }
    }

    fun getMovies(query: String, key: String): LiveData<Media> {
        job = Job()
        return object : LiveData<Media>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        try {
                            val user = apiRequest?.getPopularMovies(query, key)
                            withContext(Main) {
                                value = user
                                theJob.complete()
                            }
                        } catch (ex: JsonParsingException) {
                            Log.d("TAG", "getMovies JsonParsingException${ex.message}")
                        }

                    }

                }

            }
        }
    }
}