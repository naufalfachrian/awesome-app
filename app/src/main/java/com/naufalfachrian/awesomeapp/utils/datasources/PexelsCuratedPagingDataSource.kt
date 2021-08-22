package com.naufalfachrian.awesomeapp.utils.datasources

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.naufalfachrian.pexels_api.PexelsApiService
import com.naufalfachrian.pexels_api.entities.PexelsPhoto
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class PexelsCuratedPagingDataSource : RxPagingSource<Int, PexelsPhoto>() {

    override fun getRefreshKey(state: PagingState<Int, PexelsPhoto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, PexelsPhoto>> {
        val pageNumberToLoad = params.key ?: 1
        return PexelsApiService.instance.fetchCuratedPhotos(pageNumberToLoad, params.loadSize)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, PexelsPhoto>> { response -> LoadResult.Page(response.photos, null, response.page + 1) }
            .onErrorReturn { error -> LoadResult.Error(error) }
            .singleOrError()
    }

}