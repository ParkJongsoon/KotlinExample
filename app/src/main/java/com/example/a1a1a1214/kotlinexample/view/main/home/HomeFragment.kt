package com.example.a1a1a1214.kotlinexample.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a1a1a1214.kotlinexample.R
import com.example.a1a1a1214.kotlinexample.view.main.home.presenter.HomeContract
import com.example.a1a1a1214.kotlinexample.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by a1a1a1214 on 2018-04-24.
 */
//v4를 한 이유는 MainActivity가 v7 서포트 라이브러리를 사용했기때문
class HomeFragment : Fragment() , HomeContract.View{

    private val homePresenter : HomePresenter by lazy {
        //여기서 해당 view를 넘김
        HomePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homePresenter.loadImage()
    }

    override fun showImage(imageName: String) {
        //R.drawable.sample_01이 아닌 resources.getIdentifier()를 통해 이미지를 가져옴
        HomeFragment_imgView.setImageResource(resources.getIdentifier(imageName, "drawable", context.packageName))
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }
}