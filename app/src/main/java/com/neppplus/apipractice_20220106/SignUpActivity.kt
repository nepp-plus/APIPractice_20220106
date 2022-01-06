package com.neppplus.apipractice_20220106

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.apipractice_20220106.api.APIList
import com.neppplus.apipractice_20220106.api.ServerAPI
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignUp.setOnClickListener {

//            입력한 아이디~폰번 추출.
            val inputEmail = edtEmail.text.toString()
            val inputPw = edtPassword.text.toString()
            val inputNickname = edtNickname.text.toString()
            val inputPhoneNum = edtPhone.text.toString()

//            API 호출 (회원가입) => ServerAPI + APIList 조합
            val retrofit = ServerAPI.getRetrofit()
            val apiList = retrofit.create(APIList::class.java)




        }

    }
}