package com.example.facebookv2.data;

import com.example.facebookv2.pojo.PostModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
   public Call<List<PostModels>> getPosts();

}
