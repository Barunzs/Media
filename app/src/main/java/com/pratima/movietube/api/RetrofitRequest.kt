package com.pratima.movietube.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType
import retrofit2.Retrofit

object RetrofitRequest {

    private var retrofit: Retrofit? = null

    @UnstableDefault
    @JvmStatic
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                val contentType = MediaType.get("application/json")
                retrofit = Retrofit.Builder()
                    .baseUrl(ApiConstants.API_BASE_URL)
                    .addConverterFactory(
                        Json(JsonConfiguration(strictMode = false)).asConverterFactory(
                            contentType
                        )
                    )
                    .build()
            }
            return retrofit
        }


}