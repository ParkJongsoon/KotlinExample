package com.example.a1a1a1214.kotlinexample.data.source.image

import com.example.a1a1a1214.kotlinexample.ImageData

/**
 * Created by js_park on 2018-04-25.
 */
//object를 사용하여 싱글톤으로 ImageRepository를 생성
object ImageRepository : ImageDataSourece
{
    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        imageLocalData.loadImageList(imageDataList, size)
    }

    private val imageLocalData : ImageLocalData by lazy {
        ImageLocalData()
    }
}