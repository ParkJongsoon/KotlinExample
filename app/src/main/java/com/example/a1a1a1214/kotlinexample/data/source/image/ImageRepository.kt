package com.example.a1a1a1214.kotlinexample.data.source.image

/**
 * Created by js_park on 2018-04-25.
 */
//object를 사용하여 싱글톤으로 ImageRepository를 생성
object ImageRepository : ImageDataSourece
{
    private val imageLocalData : ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageFileName(fileName : (String) -> Unit)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //여기서 LocalData의 파일을 불러온다. 그러므로 캐싱같은 경우 여기서 사용한다.
    }
}