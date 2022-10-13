package com.example.facebookv2.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookv2.data.PostClient;
import com.example.facebookv2.pojo.PostModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModels>> postMutableLiveData = new MutableLiveData<>();
    //Method post View Model Data
    public void getPosts(){
        PostClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModels>>() {
            @Override
            public void onResponse(Call<List<PostModels>> call, Response<List<PostModels>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModels>> call, Throwable t) {

            }
        });
    }
}
