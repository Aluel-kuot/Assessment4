package com.aluel.assessment4.UI

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.aluel.assessment4.Models.PostAdapter
//import com.aluel.assessment4.Models.Posts
//import com.aluel.assessment4.ViewModel.PostsViewModel
//import com.aluel.assessment4.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    private val postsViewModel:PostsViewModel by viewModels()
//    private lateinit var postAdapter: PostAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding=ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//    override fun onResume() {
//        super.onResume()
//
//        postsViewModel.fetchPosts()
//
//        postsViewModel.posts.observe(
//            this,
//            Observer { postsList ->
//                postAdapter = PostAdapter((postsList ?: emptyList()) as List<Posts>)
//                binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)
//                binding.rvPosts.adapter = postAdapter
//            })
//
//        postsViewModel.errorLiveData.observe(this, Observer { error ->
//            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//        })
//    }
//}


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aluel.assessment4.ViewModel.PostsViewModel
import com.aluel.assessment4.databinding.ActivityMainBinding
import com.aluel.assessment4.Models.PostAdapter
import com.aluel.assessment4.Models.Posts


class MainActivity : AppCompatActivity() {
    private val postsViewModel: PostsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var postAdapter : PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        postsViewModel.fetchPosts()

        postsViewModel.postsLiveData.observe(
            this,
            Observer { postsList ->
                postAdapter= PostAdapter(emptyList())
                binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvPosts.adapter = postAdapter
            })

        postsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
}



































