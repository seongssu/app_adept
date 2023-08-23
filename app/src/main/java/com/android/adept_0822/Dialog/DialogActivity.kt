package com.android.adept_0822.Dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.android.adept_0822.R
import com.android.adept_0822.databinding.ActivityAlertDialogBinding

class DialogActivity : AppCompatActivity() {
    val binding by lazy { ActivityAlertDialogBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        setContentView(binding.root)

        // 1. AlertDialog
        binding.btn1Alert.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            //다이얼로그를 설정하기 위한 AlertDialog.Builder 객체를 생성
            builder.setTitle("기본 다이얼로그 타이틀")
            //다이얼로그 상단에 표시될 텍스트, TextView를 표시할떄 setText랑 비슷한 사용법
            builder.setMessage("기본 다이얼로그 메세지")
            //다이얼로그 내에 표시될 텍스트 메시지
            builder.setIcon(R.mipmap.ic_launcher)


            val listener = object : DialogInterface.OnClickListener {
                //DialogInterface.OnClickListener : 다이얼로그 버튼 클릭 이벤트를 처리하기 위한 인터페이스
                //DialogInterface.OnClickListener : 얘를 상속받기위해서 클래스를 구현해야되는데 object:이거 하나로 모든게 생략됨
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    //p0 : 사용자의 입력을 다이얼로그와 연결시켜주는 역할을 하며, 사용자의 버튼 클릭에 따라 어떤 동작을 해야 하는지를 결정하는데 사용, null일 수 있으므로 체크해야됨
                    //p1 : 클릭된 버튼 식별
//                when (p1) {
//                    DialogInterface.BUTTON_POSITIVE ->
//                        binding.tvTitle.text = "BUTTON_POSITIVE"
//
//                    DialogInterface.BUTTON_NEUTRAL ->
//                        binding.tvTitle.text = "BUTTON_NEUTRAL"
//
//                    DialogInterface.BUTTON_NEGATIVE ->
//                        binding.tvTitle.text = "BUTTON_NEGATIVE"
//                }
                    binding.apply {
                        tvTitle.text = when (p1) {
                            DialogInterface.BUTTON_POSITIVE -> "BUTTON_POSITIVE"
                            DialogInterface.BUTTON_NEUTRAL -> "BUTTON_NEUTRAL"
                            DialogInterface.BUTTON_NEGATIVE -> "BUTTON_NEGATIVE"
                            else -> ""
                            //해당 버튼을 눌렀을때 제목이 해당 문자로 바뀜
                        }
                    }
                }
            }
            builder.setPositiveButton("Positive", listener)
            builder.setNegativeButton("Negative", listener)
            builder.setNeutralButton("Neutral", listener)
            //다이얼로그의 버튼 생성

            builder.show()
        }
    }

        // 2. CustomDialog



}