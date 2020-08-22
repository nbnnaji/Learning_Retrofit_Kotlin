package com.nkechinnaji.learningretrofit.service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nkechi Nnaji on 8/21/20.
 * Description:
 */
class Testing {

    static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
