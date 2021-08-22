package com.naufalfachrian.pexels_api.entities

import com.google.gson.annotations.SerializedName

data class PexelsPhotoResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("per_page")
    val perPage: Int,

    @SerializedName("photos")
    val photos: List<PexelsPhoto>

)