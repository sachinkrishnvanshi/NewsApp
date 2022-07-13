package com.example.newsapp.model

import com.example.newsapp.model.Articles
import com.google.gson.annotations.SerializedName


data class ExampleJson2KtKotlin (

  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : ArrayList<Articles> = arrayListOf()

)