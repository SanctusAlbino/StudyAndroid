package com.example.project02_lastproject.common;

import java.util.HashMap;
import java.util.SimpleTimeZone;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
//활용방식
public interface RetrofitInterface {

    @GET("{url}")
    Call<String> clientGetMethod(@Url String url, @QueryMap HashMap<String, Object> paramMap);
    @FormUrlEncoded
    @POST
    Call<String> clientPostMethod(@Url String url, @FieldMap HashMap<String, Object> paramMap);
}
