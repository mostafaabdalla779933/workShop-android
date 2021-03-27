package com.example.myapplication.News

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.login.LocalDataSource
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.Registration.viewmodel.RegistrationViewModel
import com.example.myapplication.Registration.viewmodel.RegistrationViewModelFactory
import com.facebook.shimmer.ShimmerFrameLayout

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: NewsAdapter
    private lateinit var shimmer: ShimmerFrameLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.news_fragment, container, false)
        recyclerView = root.findViewById(R.id.news_recycler_view)
        shimmer = root.findViewById(R.id.shimmerLayout)
        shimmer.startShimmer()
        recyclerView.setHasFixedSize(true)
        val recyclerViewManager = LinearLayoutManager(root.context)
        recyclerViewManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = recyclerViewManager
        //viewModel = ViewModelProvider(this, RegistrationViewModelFactory(RegistrationRepo(LocalDataSource()))).get(RegistrationViewModel::class.java)
        recyclerAdapter = NewsAdapter(viewModel,arrayListOf())
        recyclerView.adapter = recyclerAdapter

        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, NewsViewModelFactory(FavouriteRepo(FavouriteDataSource()),LocalDataSource())).get(NewsViewModel::class.java)
        //viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.fetchNews("tesla")
        viewModel.newsData.observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setList(ArrayList(it.articles))
            shimmer.stopShimmer()
        })
    }

}