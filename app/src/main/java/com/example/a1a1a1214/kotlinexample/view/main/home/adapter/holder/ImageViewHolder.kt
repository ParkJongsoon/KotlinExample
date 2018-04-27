package com.example.a1a1a1214.kotlinexample.view.main.home.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a1a1a1214.kotlinexample.ImageData
import com.example.a1a1a1214.kotlinexample.R
import kotlinx.android.synthetic.main.item_image_view.view.*

/**
 * Created by a1a1a1214 on 2018-04-27.
 */

//이미지뷰 홀더가 여러개 생길수 있으르모 아래와 같이 생성 viewType에 따라 다양한 viewHolder를 만들 수 있다.
class ImageViewHolder(context : Context, parent:ViewGroup?) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {

    fun onBind(item : ImageData) {
        itemView.onbind(item)
    }

    //kotlin Extension을 편하게 이용하기 위하여 아래와 같이 사용
    private fun View.onbind(item : ImageData) {
        //여기서 context는 View에 있는 context이다.
        tv_title.text = item.name
        img_view.setImageResource(resources.getIdentifier(item.fileName, "drawable", context.packageName))
    }
}