package com.neppplus.apipractice_20220106

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.apipractice_20220106.models.ProductData
import kotlinx.android.synthetic.main.activity_edit_review.*

class EditReviewActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_review)

//        이전 화면이 넘겨준 상품 데이터 받아오기
        val product = intent.getSerializableExtra("product") as ProductData

        btnSubmitReview.setOnClickListener {

            val inputTitle = edtTitle.text.toString()
            val inputContent = edtContent.text.toString()
            val inputScore = ratingBar.rating

//            서버에 전달하자. -> POST /review




        }

    }
}