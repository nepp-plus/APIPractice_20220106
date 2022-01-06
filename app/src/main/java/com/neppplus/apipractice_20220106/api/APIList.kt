package com.neppplus.apipractice_20220106.api

import com.neppplus.apipractice_20220106.models.BasicResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT

interface APIList {

//    api.gudoc.in 서버의 기능들을 접근하는 방법 (함수) 명시.

//    로그인

    @FormUrlEncoded // @Field에 데이터를 담으려면 추가로 부착해야함.
    @POST("/user")
    fun postRequestLogin(
        @Field("email") email: String,
        @Field("password") pw: String,
    ) : Call<BasicResponse>  // ( BasicResponse 형태의 응답을 받는 ) API 호출 기능을 만들어냄.

//    회원가입

    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email")  email: String,
        @Field("password") pw: String,
        @Field("nick_name") nick: String,
        @Field("phone") phone: String,
    ) : Call<BasicResponse> // 회원가입도, 로그인 처럼, code/message/data 세가지만 제일 바깥 { } 담겨있다.

}