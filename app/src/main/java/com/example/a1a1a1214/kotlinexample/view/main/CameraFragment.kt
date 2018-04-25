package com.example.a1a1a1214.kotlinexample.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a1a1a1214.kotlinexample.R
import kotlinx.android.synthetic.main.fragment_etc.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by a1a1a1214 on 2018-04-24.
 */

class CameraFragment : Fragment() {
    companion object {
        val KEY_TITLE = "key-title"
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_etc, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //arguments가 null일경우 0으로 초기화
        message.setText(arguments?.getInt(KEY_TITLE) ?: 0)
    }
}