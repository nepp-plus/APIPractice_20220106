package com.neppplus.apipractice_20220106.models

class DataResponse(
    val user: UserData,
    val token: String,
    val reviews: List<ReviewData>
) {
}