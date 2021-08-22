package com.naufalfachrian.awesomeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.naufalfachrian.pexels_api.PexelsApiService
import com.naufalfachrian.pexels_api.entities.PexelsPhoto
import kotlinx.coroutines.flow.Flow

class PexelsCuratedViewModel : ViewModel() {

    fun fetchPexelsCuratedPhotos(): Flow<PagingData<PexelsPhoto>> {
        val config = PagingConfig(PexelsApiService.DEFAULT_ITEMS_PER_PAGE)
        val pager = Pager(config, pagingSourceFactory = { PexelsCuratedPagingDataSource() })
        return pager.flow.cachedIn(viewModelScope)
    }

}