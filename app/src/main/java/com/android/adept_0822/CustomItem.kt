package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.adept_0822.databinding.ActivityCustomItemBinding

class CustomItem : AppCompatActivity() {
    private lateinit var binding : ActivityCustomItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_item)
        binding = ActivityCustomItemBinding.inflate(layoutInflater)
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

        binding.customView.adapter = CustomItemAdapter(this, dataList)

        binding.customView.setOnItemClickListener{ parent, view, position, id ->
            val name:String = (binding.customView.adapter.getItem(position)as MyItem).aName
            // getItem : 특정위치에있는 항목을 가져온다.
            // as MyItem : getItem메서드가 반환하는 객체를 MyItem 클래스로 형변환, MyItem 클래스의 객체로 사용하기 위해
            //즉, osition에 해당하는 항목의 이름을 바인딩을 통해 가져와서 name변수에 저장
            Toast.makeText(this, " $name 선택!", Toast.LENGTH_SHORT).show()
        }
    }
}