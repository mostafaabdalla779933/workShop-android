package com.example.myapplication.News

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.ArticlesItem


class NewsAdapter(private val news: ArrayList<ArticlesItem?>?) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.article_title)
        val body: TextView = view.findViewById(R.id.article_body)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.news_row, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (!news.isNullOrEmpty())
        {
            viewHolder.title.text = news[position]?.title
            viewHolder.body.text = news[position]?.description
        }

    }

    fun setList(list: ArrayList<ArticlesItem?>){
        news?.clear()
        news?.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = news?.size ?: 0

}