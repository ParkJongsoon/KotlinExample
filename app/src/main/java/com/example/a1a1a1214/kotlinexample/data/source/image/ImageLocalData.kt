package com.example.a1a1a1214.kotlinexample.data.source.image

import com.example.a1a1a1214.kotlinexample.ImageData
import com.example.a1a1a1214.kotlinexample.util.random

/**
 * Created by js_park on 2018-04-25.
 */

class ImageLocalData : ImageDataSourece{

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>()

        for (index in 1..size) {
            val name = String.format("sample_%02d",(1..10).random())
            list.add(ImageData(name, name))
        }
        //imageDataList를 콜백으로 전달
        imageDataList(list)
    }

}