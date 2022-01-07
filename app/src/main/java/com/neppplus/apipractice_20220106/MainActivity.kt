package com.neppplus.apipractice_20220106

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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

        btnViewProduct.setOnClickListener {

            val myIntent = Intent(mContext, ProductListActivity::class.java)
            startActivity(myIntent)

        }

        btnMyProfile.setOnClickListener {
            val myIntent = Intent(mContext, MyProfileActivity::class.java)
            startActivity(myIntent)
        }

        apiList.getRequestAllReview().enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful) {

                    val br = response.body()!!

//                    서버가 주는 응답 -> data -> reviews 목록 전체를 mReviewList에 추가.

                    mReviewList.addAll( br.data.reviews )

//                    리싸이클러뷰 세팅 완료 이후에 => 데이터를 추가한다면, 자동 반영 X.
//                    어댑터의 내용 변경 -> 반영 해달라. (어댑터에게 요청)
                    mReviewAdapter.notifyDataSetChanged()

                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

        mReviewAdapter = ReviewAdapter(mContext, mReviewList)
        reviewRecyclerView.adapter = mReviewAdapter
        reviewRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }
}