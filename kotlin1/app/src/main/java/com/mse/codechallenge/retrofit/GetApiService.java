package com.mse.codechallenge.retrofit;

import com.mse.codechallenge.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface GetApiService {

    @GET("/users")
    Call<List<User>> getUsers();
}