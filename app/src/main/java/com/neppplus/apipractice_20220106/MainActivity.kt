package com.neppplus.apipractice_20220106

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neppplus.apipractice_20220106.api.APIList
import com.neppplus.apipractice_20220106.api.ServerAPI
import com.neppplus.apipractice_20220106.models.BasicResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            apiList.postRequestLogin(inputEmail, inputPw).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    
//                    로그인 성공/실패던, 응답 자체가 돌아온 경우.
//                    서버가 정상 동작 함.
                    
//                    성공/실패 경우 나뉨.
                    if (response.isSuccessful) {
//                        로그인 성공 => 아이디/비번 맞음.
                        Toast.makeText(this@MainActivity, "로그인 성공.", Toast.LENGTH_SHORT).show()
                    }
                    else {
//                        로그인 실패 => 아이디 틀림 or 비번 틀림
                        Toast.makeText(this@MainActivity, "로그인 실패.", Toast.LENGTH_SHORT).show()
                    }
                    
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                    
//                    서버 연결 자체를 실패한 경우.
                    
                }

            })


        }

    }
}