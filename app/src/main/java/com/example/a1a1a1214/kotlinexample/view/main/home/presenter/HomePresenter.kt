package com.example.a1a1a1214.kotlinexample.view.main.home.presenter

import android.os.AsyncTask
import com.example.a1a1a1214.kotlinexample.data.source.image.ImageRepository
import com.example.a1a1a1214.kotlinexample.util.random
import com.example.a1a1a1214.kotlinexample.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by a1a1a1214 on 2018-04-25.
 */

/*
    HomePresenter에서는 AsyncTask를 이용해서 랜덤하게 이미지를 가져오는 기능
    AsyncTask를 사용하여 위의 기능을 구현
 */

//view는 Presenter에서 처리하면 다시 저 뷰에 전달을 해야한다.
//HomePresenter는 data.source를 통해서 받아온다.
class HomePresenter(
        val view : HomeContract.View,
        private val imageRepository : ImageRepository,
        private val imageRecyclerModel : ImageRecyclerModel) : HomeContract.Presenter {

    var isLoading = false

    //HomeContract의 Presenter인터페이스
    override fun loadImage() {
        //loadImage가 실행되면 ImageAsyncTask가 실행
        ImageAsyncTask(this, view, imageRepository, imageRecyclerModel).execute()
    }

    //Background 처리, UI처리를 분리할 수 있는 AsyncTask, ImageAsyncTask를 inner로 사용시 메모리 누수가 발생될 수 있으므로 view를 파라미터로 넘기는 방식으로 작성
    class ImageAsyncTask (
            val homePresenter: HomePresenter,
            val view : HomeContract.View,
            val imageRepository : ImageRepository,
            val imageRecyclerModel : ImageRecyclerModel) : AsyncTask<Unit, Unit, Unit>()
    {
        override fun doInBackground(vararg p0: Unit?) {
            imageRepository.loadImageList( {
                it.forEach {
                    imageRecyclerModel.addItem(it)
                }
            }, 10)
            Thread.sleep(1000)
        }

        //doinBackground가 시작되기 전에 onPreExecute가 실행
        override fun onPreExecute() {
            super.onPreExecute()
            homePresenter.isLoading = true
            view.showProgress()

        }

        //doInBackground가 종료되면 onPostExecute가 실행
        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            view.hideProgress()
            imageRecyclerModel.notifyDataSetChange()

            homePresenter.isLoading = false
        }
    }



}