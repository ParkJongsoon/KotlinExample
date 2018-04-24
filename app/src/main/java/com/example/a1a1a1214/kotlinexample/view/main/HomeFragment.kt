package com.example.a1a1a1214.kotlinexample.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a1a1a1214.kotlinexample.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by a1a1a1214 on 2018-04-24.
 */
//v4를 한 이유는 MainActivity가 v7 서포트 라이브러리를 사용했기때문
class HomeFragment : Fragment() {

    companion object {
        val KEY_TITLE = "key-title"
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //arguments가 null일경우 0으로 초기화
        message.setText(arguments?.getInt(KEY_TITLE) ?: 0)
    }
}