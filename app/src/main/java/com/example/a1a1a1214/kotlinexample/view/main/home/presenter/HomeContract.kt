package com.example.a1a1a1214.kotlinexample.view.main.home.presenter

/**
 * Created by a1a1a1214 on 2018-04-25.
 */

interface HomeContract
{
    interface  View
    {
        fun hideProgress()
        fun showProgress()
    }

    interface Presenter
    {
        fun loadImage()
    }
}