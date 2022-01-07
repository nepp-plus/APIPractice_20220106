package com.neppplus.apipractice_20220106

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.apipractice_20220106.models.BasicResponse
import com.neppplus.apipractice_20220106.models.ReviewData
import kotlinx.android.synthetic.main.activity_view_review.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewReviewActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_review)

        val reviewData = intent.getSerializableExtra("review") as ReviewData

        apiList.getRequestReviewDetail(reviewData.id).enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                val br = response.body()!!

                val newReviewData = br.data.review

                txtReviewTitle.text = newReviewData.title
                txtReviewContent.text = newReviewData.content


            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

    }
}