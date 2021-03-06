package com.example.sayone.restapidemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("login/")
    Call<ResponseBody> login(@Body Login login);

    @GET("account/user/")
    Call<ResponseBody> getUserData();

}
