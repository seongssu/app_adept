package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.adept_0822.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {
    private lateinit var binding :ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.character1,"Bella","1"))
        dataList.add(MyItem(R.drawable.character2,"Charlie","2"))
        dataList.add(MyItem(R.drawable.character3,"Daisy","1.5"))
        dataList.add(MyItem(R.drawable.character4,"Duke","1"))
        dataList.add(MyItem(R.drawable.character5,"Max","2"))
        dataList.add(MyItem(R.drawable.character6,"Happy","4"))
        dataList.add(MyItem(R.drawable.character7,"Luna","3"))
        dataList.add(MyItem(R.drawable.character8,"Bob","2"))
        dataList.add(MyItem(R.drawable.character1,"Bella","1"))
        dataList.add(MyItem(R.drawable.character2,"Charlie","2"))
        dataList.add(MyItem(R.drawable.character3,"Daisy","1.5"))
        dataList.add(MyItem(R.drawable.character4,"Duke","1"))
        dataList.add(MyItem(R.drawable.character5,"Max","2"))
        dataList.add(MyItem(R.drawable.character6,"Happy","4"))
        dataList.add(MyItem(R.drawable.character7,"Luna","3"))
        dataList.add(MyItem(R.drawable.character8,"Bob","2"))

        binding.recyclerView.adapter = RecyclerViewAdapter(dataList)

        val adapter = RecyclerViewAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : RecyclerViewAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                //클릭 이벤트를 처리할 익명 클래스를 할당하고, 이 클래스에서 클릭 이벤트를 처리, 즉 리사이클러뷰의 각 아이템이 클릭될때 원하는 동작을 수행할 수 있다.
                val name: String = dataList[position].aName
                Toast.makeText(this@RecyclerView, "$name 선택!!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}