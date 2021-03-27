package com.example.myapplication.News

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.NewsFragmentBinding

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var recyclerView: RecyclerView
    lateinit var binding: NewsFragmentBinding
    val TAG="main"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= NewsFragmentBinding.inflate(layoutInflater)
        val root = inflater.inflate(R.layout.news_fragment, container, false)
        recyclerView = root.findViewById(R.id.news_recycler_view)
        recyclerView.setHasFixedSize(true)
        val recyclerViewManager = LinearLayoutManager(root.context)
        recyclerViewManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = recyclerViewManager
        recyclerView.adapter
        viewModel = NewsViewModel()
        viewModel.fetchNews("tesla")



//        binding.searchBar.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {
//
//            override fun onQueryTextChange(newText: String): Boolean {
//
//
//                return false
//            }
//
//            override fun onQueryTextSubmit(query: String): Boolean {
//
//
//
//                return false
//            }
//
//        })

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(txt: String?): Boolean {

                Log.i(TAG, "onQueryTextSubmit: "+txt)

                return false
            }
            override fun onQueryTextChange(txt: String?): Boolean {

                Log.i(TAG, "onQueryTextChange: "+txt)

                return false
            }
        })





        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.newsData.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = NewsAdapter(it.articles)
        })
    }

}