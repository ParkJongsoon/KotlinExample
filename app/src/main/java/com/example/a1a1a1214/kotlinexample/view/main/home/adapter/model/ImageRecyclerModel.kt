package com.example.a1a1a1214.kotlinexample.view.main.home.adapter.model

import com.example.a1a1a1214.kotlinexample.ImageData

/**
 * Created by a1a1a1214 on 2018-04-27.
 */

//외부에서 접근하기 위한 Model

interface ImageRecyclerModel {

    fun addItem(imageData : ImageData) { }

    fun getItemCount() : Int

    fun notifyDataSetChange() { }

}