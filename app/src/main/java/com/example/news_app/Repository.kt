package com.example.news_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.news_app.Network.NewsService
import com.example.news_app.db.News
import javax.inject.Inject

class Repository @Inject constructor(private val newsService: NewsService) {

    val liveData:MutableLiveData<News> = MutableLiveData<News>()

    val liveinstance:LiveData<News>
        get() {
           return liveData
        }

    fun getnews(page:Int){
        val data=newsService.getnewsapi(page)
        if (data!=null){
           liveData.postValue(data.body())
        }
    }
}