package com.example.a1a1a1214.kotlinexample.view.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.a1a1a1214.kotlinexample.R
import com.example.a1a1a1214.kotlinexample.util.replace
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Fragment는 한번만 생성
    private val homeFragment : HomeFragment by lazy {
        //생성과 동시에 arguments를 생성
        HomeFragment().apply {
            arguments = Bundle().apply {
                putInt(HomeFragment.KEY_TITLE, R.string.title_home)
            }
        }
    }
    private val cameraFragment : CameraFragment by lazy {
        CameraFragment().apply {
            arguments = Bundle().apply {
                putInt(CameraFragment.KEY_TITLE, R.string.title_camera)
            }
        }
    }
    private val moreFragment : MoreFragment by lazy {
        MoreFragment().apply {
            arguments = Bundle().apply {
                putInt(MoreFragment.KEY_TITLE, R.string.title_more)
            }
        }
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replace(R.id.container, homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_camera -> {
                replace(R.id.container, cameraFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                replace(R.id.container, moreFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //util에 생성한 확장함수
        replace(R.id.container, homeFragment)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
