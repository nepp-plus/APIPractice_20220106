package com.neppplus.apipractice_20220106

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.neppplus.apipractice_20220106.adapters.ReviewAdapter
import com.neppplus.apipractice_20220106.models.BasicResponse
import com.neppplus.apipractice_20220106.models.ReviewData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    val mReviewList = ArrayList<ReviewData>()

    lateinit var mReviewAdapter: ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiList.getRequestAllReview().enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful) {

                    val br = response.body()!!

//                    서버가 주는 응답 -> data -> reviews 목록 전체를 mReviewList에 추가.

                    mReviewList.addAll( br.data.reviews )

                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

        mReviewAdapter = ReviewAdapter(mContext, mReviewList)
        reviewRecyclerView.adapter = mReviewAdapter
        reviewRecyclerView.layoutManager = LinearLayoutManager(mContext)

    }
}