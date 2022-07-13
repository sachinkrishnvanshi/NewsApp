package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.callBack.DataTransferNews
import com.example.newsapp.callBack.NewsInterface
import com.example.newsapp.model.ExampleJson2KtKotlin
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment() : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_news , container , false)
        return  view
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        val length= getNewsUpdate()
        Toast.makeText(requireContext() , "${length}" , Toast.LENGTH_SHORT).show()

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_recycler.layoutManager=LinearLayoutManager(requireContext())

    }
    fun getNewsUpdate():Int{
        var size=0
        val news: Call<ExampleJson2KtKotlin> = NewsInterface.NewsService.newsInstance.getNews("us",1)
        news.enqueue(object: Callback<ExampleJson2KtKotlin> {
            override fun onResponse(
                call: Call<ExampleJson2KtKotlin>,
                response: Response<ExampleJson2KtKotlin>
            ) {
                val respose : ExampleJson2KtKotlin? = response.body()
                Log.e("t","${respose}")

                PagerSnapHelper().attachToRecyclerView(news_recycler)

                size=respose?.articles?.size!!.toInt()

                news_recycler.adapter= NewsAdapter(respose!!.articles,requireContext() )
            }
            override fun onFailure(call: Call<ExampleJson2KtKotlin> , t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return  size
    }

}
