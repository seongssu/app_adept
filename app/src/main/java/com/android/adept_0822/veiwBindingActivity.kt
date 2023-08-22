package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.adept_0822.databinding.ActivityMainBinding

class veiwBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //ActivityMainBinding : viewBinding 라이브러리에 의해 자동생성된 클래스
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //inflate(layoutInflater) : 해당 엑티비티나 프래그먼트(layoutInflater)의 xml파일을 메모리에 로드, 그에 대한 binding객체 생성
        //레이아웃에서 정의한 버튼이나 텍스트뷰같은 뷰 요소에 접근할 수있다. (findViewById를 대체한다. null safety, 가독성)
        setContentView(binding.root)
        //binding : view Binding을 통해 생성된  바인딩 객체
        //binding.root : 해당 엑티비티나 프래그먼트의 xml 파일의 루트 뷰
        //setContentView(binding.root)를 호출하면 엑티비티나 프래그먼트의 화면이 binding.root에 정의된 xml 레이아웃으로 설정

        binding.myButton.setOnClickListener {
            binding.myTextView.text = "바인딩이 잘 되네요"
        }
        //binding : 바인딩 객체를 사용해서 버튼이나 텍스트 뷰같은 요소에 접근
        //findViewById를 써서 객체에 담고 그걸로 다시 setOnClickListener, text를 써야되는데 가독성 좋다.
    }
}