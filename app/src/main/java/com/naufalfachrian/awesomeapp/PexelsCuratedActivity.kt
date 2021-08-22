package com.naufalfachrian.awesomeapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalfachrian.awesomeapp.databinding.ActivityPexelsCuratedBinding

class PexelsCuratedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPexelsCuratedBinding

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
        binding.recyclerView.adapter = ListAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun activateGridMode() {
        binding.recyclerView.adapter = GridAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

}