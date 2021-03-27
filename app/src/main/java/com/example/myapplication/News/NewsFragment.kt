package com.example.myapplication.News

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
    lateinit var recyclerAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = NewsViewModel()
        binding= NewsFragmentBinding.inflate(layoutInflater, container, false)

        val root = inflater.inflate(R.layout.news_fragment, container, false)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.fetchNews("tesla")
        viewModel.newsData.observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setList(ArrayList(it.articles))
        })
        recyclerView = root.findViewById(R.id.news_recycler_view)
        recyclerView.setHasFixedSize(true)
        val recyclerViewManager = LinearLayoutManager(root.context)
        recyclerViewManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = recyclerViewManager

        recyclerView.adapter

        viewModel.fetchNews("tesla")

        binding.searchBar.setOnClickListener(View.OnClickListener {

            Log.i(TAG, "onCreateView: ")
        })


        binding.searchBar.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i("main", s.toString())
            }
        })

//        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(txt: String?): Boolean {
//
//                Log.i(TAG, "onQueryTextSubmit: "+txt)
//
//                return false
//            }
//            override fun onQueryTextChange(txt: String?): Boolean {
//
//                Log.i(TAG, "onQueryTextChange: "+txt)
//
//                return false
//            }
//        })









        recyclerAdapter = NewsAdapter(arrayListOf())
        recyclerView.adapter = recyclerAdapter


        return root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }



}