package com.example.news_app.Network

import com.example.news_app.db.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
const val BASE_URL="https://newsapi.org/"
const val API_KEY="695ce05b874c4966afd3ca92f2993648"
interface NewsService {

    @GET("v2/everything?q=tesla&apiKey=$API_KEY")
    suspend fun getnewsapi(@Query("page")page:Int):Response<News>
}