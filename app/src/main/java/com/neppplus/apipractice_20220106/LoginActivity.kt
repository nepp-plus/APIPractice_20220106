package com.neppplus.apipractice_20220106

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neppplus.apipractice_20220106.api.APIList
import com.neppplus.apipractice_20220106.api.ServerAPI
import com.neppplus.apipractice_20220106.models.BasicResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

//            입력한 이메일 / 비번 변수에 저장
            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()


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
//                        Toast.makeText(this@MainActivity, "로그인 성공.", Toast.LENGTH_SHORT).show()
                        
//                        ~~님 환영합니다! 토스트 출력 => 로그인 한 사람의 닉네임 추출.
                        
                        val br = response.body()!!  // 서버의 응답 본문(body) 을 자동 분석된 BasicResponse형태로 저장.
                        
                        val loginUserNick = br.data.user.nick_name

                        Toast.makeText(this@LoginActivity, "${loginUserNick}님, 환영합니다!", Toast.LENGTH_SHORT).show()

//                        메인화면으로 이동
                        val myIntent = Intent(mContext, MainActivity::class.java)
                        startActivity(myIntent)

                        finish()

                    }
                    else {
//                        로그인 실패 => 아이디 틀림 or 비번 틀림
                        Toast.makeText(this@LoginActivity, "로그인 실패.", Toast.LENGTH_SHORT).show()
                    }
                    
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                    
//                    서버 연결 자체를 실패한 경우.
                    
                }

            })


        }


        btnSignUp.setOnClickListener {

//            단순 화면 이동.
            val myIntent = Intent(this, SignUpActivity::class.java)
            startActivity(myIntent)

        }

    }
}