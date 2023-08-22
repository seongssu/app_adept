package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.adept_0822.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding:ActivityListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = arrayOf<String?>("item1","item2","item3","item4","item5","item6","item7","item8")
        // 데이터 원본

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,items)
        //어댑터
        //ListView, GridView와 같은 어댑터 뷰에 표시하기위한 어댑터 클래스
        //ArrayAdapter : 데이터를 표시하는 어댑터클래스
        //this : 현재 의 액티비티, 프래그먼트 를 나타낸다.
        //android.R.layout : 레이아웃 리소스 , 뒤에 Id를 붙여서 사용
        //1. android.R.layout.simple_list_item_1 : 하나의 텍스트 뷰
        //2. android.R.layout.simple_list_item_2 : 두개의 텍스트 뷰
        //3. android.R.layout.simple_list_checked : 오른쪽에 체크 표시
        //4. android.R.layout.simple_list_single_choice : 오른쪽에 라디오 버튼
        //5. android.R.layout.simple_list_multiple_choice : 오른쪽에 체크 버튼
        //6. 바로위에서 선언한 item데이터

        binding.listView.adapter = adapter
        //어댑터를 ListView객체에 연결
    }
}