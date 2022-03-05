package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: myAdapter
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel=ViewModelProvider(this,ViewModelFactory(application)).get(MainViewModel::class.java)
        setupthings()
    }

    private fun setupthings() {
        mainViewModel.livelong.observe(this, Observer {
            if (it!=null) {
                recyclerview.apply {
                    myAdapter = myAdapter(this@MainActivity, it.articles)
                    adapter=myAdapter
                    layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }
        })

    }
}