package com.naufalfachrian.awesomeapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.naufalfachrian.awesomeapp.databinding.ActivityPexelsCuratedBinding

class PexelsCuratedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPexelsCuratedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPexelsCuratedBinding.inflate(layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_view_mode, menu)
        return super.onCreateOptionsMenu(menu)
    }

}