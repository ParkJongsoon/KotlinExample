package com.example.a1a1a1214.kotlinexample.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a1a1a1214.kotlinexample.R
import com.example.a1a1a1214.kotlinexample.data.source.image.ImageRepository
import com.example.a1a1a1214.kotlinexample.view.main.home.adapter.ImageRecyclerAdapter
import com.example.a1a1a1214.kotlinexample.view.main.home.presenter.HomeContract
import com.example.a1a1a1214.kotlinexample.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by a1a1a1214 on 2018-04-24.
 */
//v4를 한 이유는 MainActivity가 v7 서포트 라이브러리를 사용했기때문
class HomeFragment : Fragment() , HomeContract.View{

    private val homePresenter : HomePresenter by lazy {
        //presenter에다가 recyclerAdapeter를 넘겨 presenter에서 adapter를 통해 Model에 접근
        HomePresenter(this, ImageRepository, imaageRecyclerAdapter)
    }

    private val imaageRecyclerAdapter : ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this@HomeFragment.context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homePresenter.loadImage()
        recycler_view.run{
            adapter =imaageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
            //계속적으로 추가할 경우 remove를 실행해줘야한다.
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler_view?.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = recyclerView?.childCount as Int
            val totalItemCount = imaageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            //특정 카운트시 아이템을 더 가져오기
            if(!homePresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount -5 )
            {
                homePresenter.loadImage()
            }
        }
    }
}