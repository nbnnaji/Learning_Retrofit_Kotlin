package com.nkechinnaji.learningretrofit.model

import com.nkechinnaji.learningretrofit.uiutils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor


/**
 * Created by Nkechi Nnaji on 8/21/20.
 * Description:
 */
object ServiceGenerator {

    private var builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private var retrofit: Retrofit = builder.build()

    //Add logging
    private val loggingInterceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private var httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

    fun <S> createService(serviceClass: Class<S>?): S {

        if (!httpClientBuilder.interceptors().contains(loggingInterceptor)) {
            httpClientBuilder.addInterceptor(loggingInterceptor)
            builder = builder.client(httpClientBuilder.build())
            retrofit = builder.build()
        }
        return retrofit.create(serviceClass)
    }
}