package com.naufalfachrian.awesomeapp

import com.naufalfachrian.pexels_api.PexelsApiService
import org.junit.Test

class PexelsApiTest {

    @Test
    fun checkIfApiReturnSuccess() {
        val pageToLoad = 1
        val response = PexelsApiService.instance.fetchCuratedPhotos(pageToLoad).blockingFirst()
        assert(response.perPage == PexelsApiService.DEFAULT_ITEMS_PER_PAGE)
        assert(response.page == pageToLoad)
    }

}