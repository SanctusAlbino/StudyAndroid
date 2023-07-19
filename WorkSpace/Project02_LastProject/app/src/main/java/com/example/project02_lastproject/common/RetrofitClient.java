package com.example.project02_lastproject.common;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
//접속정보
public class RetrofitClient {

    public Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.122:8080/middle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return retrofit;
    }
}
