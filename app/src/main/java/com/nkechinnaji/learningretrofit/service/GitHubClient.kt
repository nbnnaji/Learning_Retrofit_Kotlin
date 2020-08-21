package com.nkechinnaji.learningretrofit.service

import com.nkechinnaji.learningretrofit.model.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Nkechi Nnaji on 8/21/20.
 * Description:
 */
interface GitHubClient {
    @GET("/users/{user}/repos")
    fun reposForUser(@Path("user") user: String?): Call<List<GitHubRepo>>
}