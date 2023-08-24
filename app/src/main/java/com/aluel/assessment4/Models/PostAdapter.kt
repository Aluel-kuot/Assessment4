package com.aluel.assessment4.Models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aluel.assessment4.databinding.PostsListBinding


class PostAdapter(var postsList:List<Posts>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PostViewHolder {
        val binding =
            PostsListBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost =postsList[position]
        var  binding=holder.binding
        binding.tvUserID.text=currentPost.userId.toString()
        binding.tvId.text=currentPost.id.toString()
        binding.tvTitle.text=currentPost.title.toString()
        binding.tvBody.text=currentPost.body.toString()

    }
    override fun getItemCount(): Int {
        return postsList.size
    }
}
class PostViewHolder( var binding:PostsListBinding): RecyclerView.ViewHolder(binding.root)

