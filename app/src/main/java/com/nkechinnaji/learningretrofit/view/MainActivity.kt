package com.nkechinnaji.learningretrofit.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nkechinnaji.learningretrofit.R
import com.nkechinnaji.learningretrofit.model.GitHubRepo
import com.nkechinnaji.learningretrofit.service.GitHubClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(){

    var adapter: GitHubRepoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit: Retrofit = builder.build()

        val client: GitHubClient = retrofit.create(GitHubClient::class.java)
        val call= client.reposForUser("nbnnaji")


        call.enqueue(object: Callback<List<GitHubRepo>> {
            override fun onFailure(call: Call<List<GitHubRepo>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error :(", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<GitHubRepo>>, response: Response<List<GitHubRepo>>) {

                if(response.isSuccessful){
                    val repos: List<GitHubRepo>? = response.body()
                    adapter = repos?.let { GitHubRepoAdapter(this@MainActivity, it) }
                    pagination_list.adapter = adapter
                }
                else{
                    Log.e("RETROFIT TEST: ", "Not sure you are working!");
                }



            }

        })

    }

}