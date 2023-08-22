package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        binding.imageGridView.setOnItemClickListener{parent,view,position,id ->
            //parent : AdapterView (ImageAdapter)를 나타낸다.
            //view : 클릭된 항목을 나타내는 뷰
            //position : 클릭된 항목의 위치
            //id : 클릭된 항목의 고유 ID
            Toast.makeText(this@ImageGridView,"" + (position +1) + "번째 선택", Toast.LENGTH_SHORT).show()
        }
    }
}