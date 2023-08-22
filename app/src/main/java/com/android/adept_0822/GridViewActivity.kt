package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.adept_0822.databinding.ActivityGridViewBinding

class GridViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGridViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

       binding = ActivityGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = arrayOf<String?>("item1","item2","item3","item4","item5","item6","item7","item8","item2","item3","item4","item5","item6","item7","item8","item2","item3","item4","item5","item6","item7","item8","item2","item3","item4","item5","item6","item7","item8")

        val adapt = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        binding.gridView.adapter = adapt

    }
}