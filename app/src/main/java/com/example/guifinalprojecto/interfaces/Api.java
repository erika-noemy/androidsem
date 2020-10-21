package com.example.guifinalprojecto.interfaces;

import com.example.guifinalprojecto.adapters.structRests;
import com.example.guifinalprojecto.models.logInResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("user/login")
    Call<logInResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("res")
    Call<ArrayList<structRests>> getRests();
}
