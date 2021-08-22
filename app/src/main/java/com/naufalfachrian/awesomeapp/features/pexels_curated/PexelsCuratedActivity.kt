package com.naufalfachrian.awesomeapp.features.pexels_curated

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalfachrian.awesomeapp.*
import com.naufalfachrian.awesomeapp.databinding.ActivityPexelsCuratedBinding
import com.naufalfachrian.awesomeapp.utils.adapter.GridAdapter
import com.naufalfachrian.awesomeapp.utils.adapter.ListAdapter
import com.naufalfachrian.awesomeapp.utils.adapter.PexelsPhotoAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PexelsCuratedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPexelsCuratedBinding

    private val vm: PexelsCuratedViewModel by viewModels()

    lateinit var adapter: PexelsPhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPexelsCuratedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        title = ""
        activateGridMode()
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
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadPexelsPhotos()
    }

    private fun activateGridMode() {
        this.adapter = GridAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        loadPexelsPhotos()
    }

    private fun loadPexelsPhotos() {
        lifecycleScope.launch {
            vm.fetchPexelsCuratedPhotos().collectLatest {
                adapter.submitData(it)
            }
        }
    }

}