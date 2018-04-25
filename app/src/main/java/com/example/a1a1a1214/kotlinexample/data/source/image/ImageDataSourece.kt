package com.example.a1a1a1214.kotlinexample.data.source.image

/**
 * Created by js_park on 2018-04-25.
 */

interface ImageDataSourece {

    //kotlin의 고차함수 사용
    // https://medium.com/@lazysoul/high-order-function-%EA%B3%A0%EC%B0%A8%ED%95%A8%EC%88%98-22b147d0c4a5
    fun loadImageFileName( fileName : (String) -> Unit)
}