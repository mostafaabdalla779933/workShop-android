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
import com.example.myapplication.Registration.LocalDataSource
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.Registration.viewmodel.RegistrationViewModel
import com.example.myapplication.Registration.viewmodel.RegistrationViewModelFactory

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.news_fragment, container, false)
        recyclerView = root.findViewById(R.id.news_recycler_view)
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
        viewModel = ViewModelProvider(this, NewsViewModelFactory(FavouriteRepo(FavouriteDataSource()))).get(NewsViewModel::class.java)
        //viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.fetchNews("tesla")
        viewModel.newsData.observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setList(ArrayList(it.articles))
        })
    }

}