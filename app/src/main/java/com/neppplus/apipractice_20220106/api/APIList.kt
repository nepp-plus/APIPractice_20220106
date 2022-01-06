package com.neppplus.apipractice_20220106.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIList {

//    api.gudoc.in 서버의 기능들을 접근하는 방법 (함수) 명시.

//    로그인

    @FormUrlEncoded // @Field에 데이터를 담으려면 추가로 부착해야함.
    @POST("/user")
    fun postRequestLogin(
        @Field("email") email: String,
        @Field("password") pw: String,
    )


}