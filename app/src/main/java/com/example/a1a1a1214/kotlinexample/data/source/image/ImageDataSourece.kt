package com.example.a1a1a1214.kotlinexample.data.source.image

import com.example.a1a1a1214.kotlinexample.ImageData

/**
 * Created by js_park on 2018-04-25.
 */

interface ImageDataSourece {
    //callback을 ImageData타입을 갖는 List로 받는다
    fun loadImageList( imageDataList : (List<ImageData>) -> Unit, size : Int)
}