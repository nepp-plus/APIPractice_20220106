package com.neppplus.apipractice_20220106.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neppplus.apipractice_20220106.R
import com.neppplus.apipractice_20220106.models.ReviewData


class ReviewAdapter(
    val mContext: Context,
    val mList: List<ReviewData>,
) : RecyclerView.Adapter<ReviewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {

        val imgThumbnail = row.findViewById<ImageView>(R.id.imgThumbnail)
        val imgUserProfile = row.findViewById<ImageView>(R.id.imgUserProfile)
        val txtUserNickname = row.findViewById<TextView>(R.id.txtUserNickname)
        val txtReviewTitle = row.findViewById<TextView>(R.id.txtReviewTitle)

        fun bind(data: ReviewData) {

            Glide.with(mContext).load(data.thumbnail_img).into(imgThumbnail)
            Glide.with(mContext).load(data.user.profile_img).into(imgUserProfile)

            txtReviewTitle.text = data.title
            txtUserNickname.text = data.user.nick_name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.review_list_item, parent, false)
        return MyViewHolder(row)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind( mList[position] )

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}