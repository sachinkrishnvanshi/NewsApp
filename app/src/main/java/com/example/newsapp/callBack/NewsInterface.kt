package com.example.newsapp.callBack

import com.example.newsapp.model.ExampleJson2KtKotlin
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=in&apiKey=3716a312eb544536a26a7ede8ebcfb52

const val BASE_URL="https://newsapi.org/"
const val API_KEY="3716a312eb544536a26a7ede8ebcfb52"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getNews(@Query("country")country : String ,@Query("page") page : Int): Call<ExampleJson2KtKotlin>


    object NewsService {
        val newsInstance: NewsInterface

        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newsInstance = retrofit.create(NewsInterface::class.java)
        }
    }
}