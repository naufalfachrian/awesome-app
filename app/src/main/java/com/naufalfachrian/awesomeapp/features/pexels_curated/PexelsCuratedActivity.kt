package com.naufalfachrian.awesomeapp.features.pexels_curated

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalfachrian.awesomeapp.*
import com.naufalfachrian.awesomeapp.databinding.ActivityPexelsCuratedBinding
import com.naufalfachrian.awesomeapp.utils.adapter.GridAdapter
import com.naufalfachrian.awesomeapp.utils.adapter.ListAdapter
import com.naufalfachrian.awesomeapp.utils.adapter.NoInternetConnectionAdapter
import com.naufalfachrian.awesomeapp.utils.adapter.PexelsPhotoAdapter
import com.naufalfachrian.awesomeapp.utils.widget_ktx.loadImageFromNetwork
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PexelsCuratedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPexelsCuratedBinding

    private val vm: PexelsCuratedViewModel by viewModels()

    lateinit var adapter: PexelsPhotoAdapter

    companion object {

        const val APP_BAR_FEATURED_IMAGE_URL = "https://images.pexels.com/photos/2113566/pexels-photo-2113566.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPexelsCuratedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onResume() {
        super.onResume()
        activateGridMode()
        showFeaturedImage()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_view_mode, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_view_mode_grid -> {
                activateGridMode()
            }
            R.id.menu_view_mode_list -> {
                activateListMode()
            }
        }
        return true
    }

    private fun activateListMode() {
        this.adapter = ListAdapter()
        listenLoadState()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadPexelsPhotos()
    }

    private fun activateGridMode() {
        this.adapter = GridAdapter()
        listenLoadState()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        loadPexelsPhotos()
    }

    private fun showOfflineScreen() {
        binding.recyclerView.adapter = NoInternetConnectionAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadPexelsPhotos() {
        lifecycleScope.launch {
            vm.fetchPexelsCuratedPhotos().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun listenLoadState() {
        adapter.addLoadStateListener { loadState ->
            if (loadState.source.refresh is LoadState.Error) {
                showOfflineScreen()
            }
        }
    }

    private fun showFeaturedImage() {
        binding.featuredImage.loadImageFromNetwork(APP_BAR_FEATURED_IMAGE_URL)
    }

}