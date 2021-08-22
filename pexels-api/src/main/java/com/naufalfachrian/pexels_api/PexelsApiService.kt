package com.naufalfachrian.pexels_api

import com.naufalfachrian.pexels_api.entities.PexelsPhotoResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PexelsApiService {

    companion object {

        private fun connectApiService(): PexelsApiService = Retrofit.Builder()
            .baseUrl("$PEXELS_URL/$API_VERSION/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PexelsApiService::class.java)


        const val PEXELS_URL = "https://api.pexels.com"

        const val API_VERSION = "v1"

        const val DEFAULT_ITEMS_PER_PAGE = 20

        val instance = connectApiService()

    }

    @GET("curated")
    fun fetchCuratedPhotos(@Query("page") page: Int, @Query("per_page") itemsPerPage: Int = DEFAULT_ITEMS_PER_PAGE): Observable<PexelsPhotoResponse>

}