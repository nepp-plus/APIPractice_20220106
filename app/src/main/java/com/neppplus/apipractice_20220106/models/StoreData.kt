package com.neppplus.apipractice_20220106.models

import com.google.gson.annotations.SerializedName

class StoreData(
    val id: Int,
    val name: String,
    @SerializedName("logo_url")
    val logoURL: String,
) {
}