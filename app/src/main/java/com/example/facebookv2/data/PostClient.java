package com.example.facebookv2.data;

import com.example.facebookv2.pojo.PostModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    //Variables
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;
/*
* default constructor build retrofit inside */
    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface=retrofit.create(PostInterface.class);
    }

    //Getter PostClient
    public static PostClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModels>> getPosts(){
        return postInterface.getPosts();
    }
}
