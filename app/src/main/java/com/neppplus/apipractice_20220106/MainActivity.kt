package com.neppplus.apipractice_20220106

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.apipractice_20220106.api.APIList
import com.neppplus.apipractice_20220106.api.ServerAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {

//            입력한 이메일 / 비번 변수에 저장
            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()

//            서버 API의 로그인 기능에 활용. (ServerAPI 클래스 / APIList 인터페이스 결합)

            val retrofit = ServerAPI.getRetrofit() // API 연결 도구 생성
            val apiList = retrofit.create(APIList::class.java) // 연결도구 + 기능목록 결합 객체 생성.

//            실제 로그인 기능 호출 (Request)
            apiList.postRequestLogin(inputEmail, inputPw)


        }

    }
}