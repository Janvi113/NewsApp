package com.example.news_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.db.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getnews(1)
        }
    }

    val livelong:LiveData<News>
        get() {
           return repository.liveinstance
        }
}