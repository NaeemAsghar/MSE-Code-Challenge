package com.mse.codechallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mse.codechallenge.R.id.recyclerView
import com.mse.codechallenge.model.User
import com.mse.codechallenge.retrofit.GetApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://jsonplaceholder.typicode.com"
    var recyclerView: androidx.recyclerview.widget.RecyclerView? = null
    var customAdapter: RecyclerViewCustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        loadUsers()
    }

    //Load users from jsonplaceholder.typicode.com api
    fun loadUsers() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(GetApiService::class.java)
        val call = api.users

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                val userList = response?.body()
                val sortedList = userList?.sortedBy{User -> User.name }
                generateDataList(sortedList!!)
            }

            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                Log.v("Error", t.toString())
            }
        })
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    fun generateDataList(users: List<User>) {
        recyclerView = findViewById(R.id.recyclerView)
        customAdapter = RecyclerViewCustomAdapter(this, users)
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
        recyclerView!!.setLayoutManager(layoutManager)
        recyclerView!!.setAdapter(customAdapter)
    }
}