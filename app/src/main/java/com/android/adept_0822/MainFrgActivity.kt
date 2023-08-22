package com.android.adept_0822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.android.adept_0822.databinding.ActivityMainFrgBinding

class MainFrgActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainFrgBinding.inflate(layoutInflater) }

    //lazy : 필요한 경우에만 초기화되고 그렇지 않으면 초기화되지 않는다.(성능,안정성(런타임오류),가독성)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            fragment1Btn.setOnClickListener {
                setFragment(FirstFragment())
                //setFragment : 프래그먼트를 화면에 표시하거나 교체하는 용도로 쓴다.
            }
            fragment2Btn.setOnClickListener {
                setFragment(SecondFragment())
            }
        }
        setFragment(FirstFragment())    //프로그램이 실행될때 처음화면이 FirstFragment가 나오라고 다시써준거임(setOnClickListener밖에서 선언 했으니까)
    }

    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            //supportFragmentManager : 프래그먼트를 추가하거나 삭제하는등 작업을 할 수 있게 해준다.
            replace(R.id.frameLayout, frag)
            //replace : 어떤 프레임 레이아웃에 띄울것인지, 어떤프래그먼트인지
            setReorderingAllowed(true)
            // setReorderingAllowed: 일반적으로 true로 설정되어 있으며, 이때 프래그먼트는 재정렬될 수 있습니다.
            // 예를 들어, 프래그먼트 A를 제거하고 프래그먼트 B를 추가하는 작업이 true로 설정되어 있으면 가능하며, false로 설정하면 불가능하다.
            // 이 설정은 프래그먼트의 추가, 제거, 교체, 숨기기/보이기, 스택 관리 등에 영향을 준다.
            addToBackStack("")
            // addToBackStack: 트랜잭션을 백 스택에 추가하고, 뒤로가기 버튼을 누를 때 이 문자열로 트랜잭션을 식별하여 되돌아갈 페이지를 정한다.
            //괄호 안의 문자열은 트랜잭션을 식별하는 데 사용된다.
        }
    }
}