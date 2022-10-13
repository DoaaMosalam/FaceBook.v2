package com.example.facebookv2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookv2.R;
import com.example.facebookv2.databinding.ActivityMainBinding;
import com.example.facebookv2.pojo.PostModels;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PostViewModel postViewModel;
    final PostAdapter adapter = new PostAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialization Data Binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        //initialization RecyclerView
        initRecyclerView();
        //initialization postViewModel
        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModels>>() {
            @Override
            public void onChanged(List<PostModels> postModels) {
                adapter.setList(postModels);

            }
        });
    }
    /*This method init recycler view in activity main*/
    public void initRecyclerView(){
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        binding.recycler.setAdapter(adapter);


    }
}