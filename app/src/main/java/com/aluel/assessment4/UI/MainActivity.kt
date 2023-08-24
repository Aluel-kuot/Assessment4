package com.aluel.assessment4.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aluel.assessment4.R
import com.aluel.assessment4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()



































        productsViewModel.fetchProducts()
        productsViewModel.productsLiveData.observe(this, Observer{productsList ->
            var productsAdapter= ProductsAdapter(productsList?: emptyList())
            binding.rvProducts.layoutManager= GridLayoutManager(this,2)
            binding.rvProducts.adapter=productsAdapter
            Toast.makeText(baseContext, "fetched ${productsList?.size} products", Toast.LENGTH_LONG).show()
        })
        productsViewModel.errorLiveData.observe(this, Observer{error ->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
        })

    }

//



}



































//package com.example.adalabapis.ViewModel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.adalabapis.Models.Products
//import com.example.adalabapis.Repository.ProductRepository
//import kotlinx.coroutines.launch
//
//
//class ProductsViewModel: ViewModel() {
//    val productRepository = ProductRepository()
//    val productsLiveData = MutableLiveData<List<Products>>()
//    val errorLiveData = MutableLiveData<String>()
//
//    fun fetchProducts(){
//        viewModelScope.launch {
//            val response = productRepository.getProducts()
//            if(response.isSuccessful){
//                productsLiveData.postValue(response.body()?.products)
//            }
//            else{
//                errorLiveData.postValue(response.errorBody()?.string())
//            }
//        }
//    }
//}
//
//

//
//package com.example.adalabapis.Apis
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object APIClient {
//    var retrofit=Retrofit.Builder()
//        .baseUrl("https://dummyjson.com")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//
//    fun <T>buildClient(apiInterface:Class<T>):T{
//        return retrofit.create(apiInterface)
//    }
//}
//
//
//
//

//package com.example.adalabapis.Models
//
//data class ProductResponse(
//    var products:List<Products>,
//    var total:Int,
//    var skip:Int,
//    var limit:Int
//
//)
//

//package com.example.adalabapis.Models
//
//data class Products(
//    var id:Int,
//    var title:String,
//    var description:String,
//    var price:Double,
//    var rating:Double,
//    var stock:Int,
//    var category:String,
//    var thumbnail:String
//
//)
//
//
//package com.example.adalabapis.Models
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.adalabapis.databinding.ProductsListBinding
//import com.squareup.picasso.Picasso
//import jp.wasabeef.picasso.transformations.CropCircleTransformation
//
//
//class ProductsAdapter (var productList:List<Products>):RecyclerView.Adapter<ProductViewHolder>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val binding =
//            ProductsListBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
//        return ProductViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        var currentProduct =productList[position]
//        var  binding=holder.binding
//        binding.tvId.text=currentProduct.id.toString()
//        binding.tvTitle.text=currentProduct.title.toString()
//        binding.tvDescription.text=currentProduct.description.toString()
//        binding.tvPrice.text=currentProduct.price.toString()
//        binding.tvRating.text=currentProduct.rating.toString()
//        binding.tvStock.text=currentProduct.stock.toString()
//        binding.tvCategory.text=currentProduct.category.toString()
////        binding.ivThumbnail.text=currentProduct.thumbnail
//        Picasso
//            .get()
//            .load(currentProduct.thumbnail)
//            .transform(CropCircleTransformation())
//            .into(binding.ivThumbnail)
//
//    }
//    override fun getItemCount(): Int {
//        return productList.size
//    }
//}
//class ProductViewHolder( var binding:ProductsListBinding): RecyclerView.ViewHolder(binding.root)
//
//
//
//
//package com.example.adalabapis.Repository
//
//import com.example.adalabapis.Apis.APIClient
//import com.example.adalabapis.Apis.APIInterface
//import com.example.adalabapis.Models.ProductResponse
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import retrofit2.Response
//
//class ProductRepository {
//    val apiClient = APIClient.buildClient(APIInterface::class.java)
//    suspend fun getProducts(): Response<ProductResponse>{
//        return withContext(Dispatchers.IO){
//            apiClient.getProducts()
//        }
//    }
//}
//
//package com.example.adalabapis.UI
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.adalabapis.Apis.APIClient
//import com.example.adalabapis.Apis.APIInterface
//import com.example.adalabapis.Models.ProductResponse
//import com.example.adalabapis.Models.Products
//import com.example.adalabapis.Models.ProductsAdapter
//import com.example.adalabapis.ViewModel.ProductsViewModel
//import com.example.adalabapis.databinding.ActivityMainBinding
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//
//package com.example.adalabapis.ViewModel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.adalabapis.Models.Products
//import com.example.adalabapis.Repository.ProductRepository
//import kotlinx.coroutines.launch
//
//
//class ProductsViewModel: ViewModel() {
//    val productRepository = ProductRepository()
//    val productsLiveData = MutableLiveData<List<Products>>()
//    val errorLiveData = MutableLiveData<String>()
//
//    fun fetchProducts(){
//        viewModelScope.launch {
//            val response = productRepository.getProducts()
//            if(response.isSuccessful){
//                productsLiveData.postValue(response.body()?.products)
//            }
//            else{
//                errorLiveData.postValue(response.errorBody()?.string())
//            }
//        }
//    }
