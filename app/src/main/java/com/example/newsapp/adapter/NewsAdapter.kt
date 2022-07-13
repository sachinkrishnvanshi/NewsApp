package com.example.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.model.Articles
import kotlinx.android.synthetic.main.news_item_layout.view.*

class NewsAdapter(val list: List<Articles>, val context: Context): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {


    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder , position: Int) {
        val data:Articles = list[position]
        holder.itemView.tv_title.text=data.title
        holder.itemView.tv_description.text=data.description
        Glide.with(context).load(data.urlToImage).into(holder.itemView.iv_news)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}