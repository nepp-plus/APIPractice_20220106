package com.neppplus.apipractice_20220106.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductData(
    val id: Int,
    val name: String,
    val price: Int,
    @SerializedName("image_url")
    val imageURL: String,  // 서버가 주는 이름표와, 저장하려는 변수명이 다를때
    val store: StoreData,
) : Serializable {
}