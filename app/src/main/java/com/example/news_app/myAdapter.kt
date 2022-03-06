package com.example.news_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_app.activity.webview
import com.example.news_app.db.Articles
import com.example.news_app.db.News

class myAdapter(val context: Context,val itemlist:List<Articles>):RecyclerView.Adapter<myAdapter.myviewholder>() {
    inner class myviewholder(itemView: View) :RecyclerView.ViewHolder(itemView){
       val ttl=itemView.findViewById<TextView>(R.id.ttl)
        val des=itemView.findViewById<TextView>(R.id.des)
        val imag=itemView.findViewById<ImageView>(R.id.image_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.newsitems,parent,false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
       val data=itemlist[position]
        holder.ttl.text=data.title
        holder.des.text=data.description
        Glide.with(context)
            .load(data.urlToImage)
            .into(holder.imag)
        holder.itemView.setOnClickListener {
            val intent= Intent(context,webview::class.java)
            intent.putExtra("web",data.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return itemlist.size
    }
}