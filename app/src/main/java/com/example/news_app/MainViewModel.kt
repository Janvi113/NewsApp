package com.example.news_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.news_app.db.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application: Application):AndroidViewModel(application) {

    lateinit var repository:Repository
    init {
        viewModelScope.launch {
            repository.getnews(1)
        }
    }

    val livelong:LiveData<News>
        get() {
           return repository.liveData
        }
}