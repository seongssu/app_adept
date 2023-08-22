package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.adept_0822.databinding.ActivityImageGridViewBinding

class ImageGridView : AppCompatActivity() {
    private lateinit var binding : ActivityImageGridViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_grid_view)

        binding = ActivityImageGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageGridView.adapter = ImageAdapter()
        //imageGridView : xml의 id
    }
}