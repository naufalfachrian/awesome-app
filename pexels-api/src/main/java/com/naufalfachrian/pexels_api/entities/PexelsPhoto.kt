package com.naufalfachrian.pexels_api.entities

import com.google.gson.annotations.SerializedName

data class PexelsPhoto(

    @SerializedName("id")
    val id: Int,

    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("url")
    val url: String,

    @SerializedName("photographer")
    val photographer: String,

    @SerializedName("photographer_url")
    val photographerUrlString: String,

    @SerializedName("photographer_id")
    val photographerId: Int,

    @SerializedName("avg_color")
    val avgColorHexString: String,

    @SerializedName("src")
    val source: Source

) {

    data class Source(

        @SerializedName("original")
        val original: String,

        @SerializedName("large2x")
        val large2x: String,

        @SerializedName("large")
        val large: String,

        @SerializedName("medium")
        val medium: String,

        @SerializedName("small")
        val small: String,

        @SerializedName("portrait")
        val portrait: String,

        @SerializedName("landscape")
        val landscape: String,

        @SerializedName("tiny")
        val tiny: String

    )

}