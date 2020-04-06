package com.pratima.movietube.model

import android.util.Log
import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

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
    var backdrop_path: String? = null,
    var original_title: String = "",
    var original_name: String = ""
) {
    @Serializer(forClass = Media::class)
    companion object : KSerializer<Media> {
        override val descriptor: SerialDescriptor =
            StringDescriptor.withName("Media")

        override fun serialize(encoder: Encoder, obj: Media) {
            Log.d("serialize", "serialize called")
        }

    }
}