package com.example.a1a1a1214.kotlinexample.util

import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by a1a1a1214 on 2018-04-24.
 */

//Fragment Replace 관련 확장 함수

fun AppCompatActivity.replace(@IdRes frameId: Int, fragment : android.support.v4.app.Fragment, tag : String ? = null)
{
    supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()
}