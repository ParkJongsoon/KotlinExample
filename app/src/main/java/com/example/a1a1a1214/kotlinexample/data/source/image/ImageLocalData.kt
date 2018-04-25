package com.example.a1a1a1214.kotlinexample.data.source.image

import com.example.a1a1a1214.kotlinexample.util.random

/**
 * Created by js_park on 2018-04-25.
 */

class ImageLocalData : ImageDataSourece{
    override fun loadImageFileName(fileName : (String) -> Unit)
    {
        //호출이 일어나면 여기서 fileName을 넘겨준다
        fileName(String.format("sample_%02d", (1..10).random()))
    }
}