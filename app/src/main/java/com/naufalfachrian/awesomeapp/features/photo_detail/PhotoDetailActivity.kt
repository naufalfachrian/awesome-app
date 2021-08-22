package com.naufalfachrian.awesomeapp.features.photo_detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.naufalfachrian.awesomeapp.databinding.ActivityPhotoDetailBinding
import com.naufalfachrian.awesomeapp.utils.parcels.PexelsPhotoParcel
import com.naufalfachrian.awesomeapp.utils.widget_ktx.loadImageFromNetwork
import com.naufalfachrian.pexels_api.entities.PexelsPhoto

class PhotoDetailActivity : AppCompatActivity() {

    companion object {

        const val PHOTO_DETAIL = "PHOTO_DETAIL"

        @JvmStatic
        fun start(context: Context, photo: PexelsPhoto) {
            val starter = Intent(context, PhotoDetailActivity::class.java).apply {
                putExtra(PHOTO_DETAIL, PexelsPhotoParcel(photo))
            }
            context.startActivity(starter)
        }

    }

    private lateinit var binding: ActivityPhotoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoDetailBinding.inflate(layoutInflater)
        binding.photo = intent.getParcelableExtra<PexelsPhotoParcel>(PHOTO_DETAIL)?.unParcel()
        binding.textViewUrlToPexels.setOnClickListener { showInBrowser() }
        setContentView(binding.root)
        showImage()
        title = ""
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    private fun showImage() {
        val imageUrl = binding.photo?.source?.large2x
        if (imageUrl != null) {
            binding.featuredImage.loadImageFromNetwork(imageUrl)
        }
    }
    private fun showInBrowser() {
        val url = binding.photo?.url
        if (url != null) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

}