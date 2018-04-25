package com.example.a1a1a1214.kotlinexample.view.main.home.presenter

import android.os.AsyncTask
import com.example.a1a1a1214.kotlinexample.util.random

/**
 * Created by a1a1a1214 on 2018-04-25.
 */

/*
    HomePresenter에서는 AsyncTask를 이용해서 랜덤하게 이미지를 가져오는 기능
    AsyncTask를 사용하여 위의 기능을 구현
 */

//view는 Presenter에서 처리하면 다시 저 뷰에 전달을 해야한다.
class HomePresenter(val view : HomeContract.View) : HomeContract.Presenter {

    //HomeContract의 Presenter인터페이스
    override fun loadImage() {
        //loadImage가 실행되면 ImageAsyncTask가 실행
        ImageAsyncTask(view).execute()
    }

    //Background 처리, UI처리를 분리할 수 있는 AsyncTask, ImageAsyncTask를 inner로 사용시 메모리 누수가 발생될 수 있으므로 view를 파라미터로 넘기는 방식으로 작성
    class ImageAsyncTask (val view : HomeContract.View) : AsyncTask<Unit, Unit, String>()
    {
        override fun doInBackground(vararg p0: Unit?): String {
            Thread.sleep(1000)
            //이미지(sample_01~10)를 랜덤하게 가져와 String을 넘김
            return String.format("sample_%02d", (1..10).random())
        }

        //doinBackground가 시작되기 전에 onPreExecute가 실행
        override fun onPreExecute() {
            super.onPreExecute()
            view.showProgress()
        }

        //doInBackground가 종료되면 onPostExecute가 실행
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            view.hideProgress()
            //result가 null잀 수 있으므로 let으로 감싸서
            result?.let {
                //결과가 null이 아닐 경우에 넘김
                view.showImage(it)
            }
        }
    }



}