package com.neppplus.apipractice_20220106.utils

import android.content.Context

class ContextUtil {

//    기능을 수행할때 -> Context를 필요로 하는 기능들을 모아두는 클래스.
//    단순 기능 -> 어떤 객체 (인스턴스) 가 하던 관계 없다.
//     => ex. 랜덤값 뽑기.  1번랜덤? 2번랜덤? 어느 객체던, 결과만 랜덤으로 잘 나오면 됨.
//     => 클래스이름.기능() 형태로 코딩하는게 낫다.

    companion object {

//        일종의 메모장 (SharedPreferences) 에 여러 항목들 저장 예정.
//         => 메모장 파일의 이름이 필요.

        val PREF_NAME = "APIPracticePref"   // 메모장 이름

//        항목의 키 값도 변수에 담아두자. (오타 방지용)
//        저장 기능 / 조회 기능 2개 기능 필요. => 둘의 키값 통일 필요.

        val TOKEN = "TOKEN"

        fun setToken(context: Context, token: String) {
            val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) // 메모장 파일 열기
            pref.edit().putString(TOKEN, token).apply()  // String 하나 추가 기록 -> 저장 (apply)
        }

    }


}