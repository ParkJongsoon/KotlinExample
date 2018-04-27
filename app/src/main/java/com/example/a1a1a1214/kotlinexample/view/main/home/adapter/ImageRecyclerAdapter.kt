package com.example.a1a1a1214.kotlinexample.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.a1a1a1214.kotlinexample.ImageData
import com.example.a1a1a1214.kotlinexample.view.main.home.adapter.holder.ImageViewHolder
import com.example.a1a1a1214.kotlinexample.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by a1a1a1214 on 2018-04-27.
 */

class ImageRecyclerAdapter (private val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel {

    private val list = mutableListOf<ImageData>()

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        //여기서 홀더가 넘어오면 홀더가 imageViewHolder인지 확인 후 onBind 실행
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder (context, parent)
    }

    override fun addItem(imageData: ImageData) {
        list.add(imageData)
    }

    override fun notifyDataSetChange() {
        notifyDataSetChanged()
    }
}