package com.example.androidcrud.Interface;

import com.example.androidcrud.Models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceAPI {
    @GET("users")
    Call<UserModel> getData();
}
