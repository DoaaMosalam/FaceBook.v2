package com.example.facebookv2.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModels;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<PostModels> list = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.titleTV.setText(list.get(position).getTitle());
        holder.userTV.setText(list.get(position).getUserId()+"");
        holder.bodyTV.setText(list.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<PostModels> postModelsList) {
        this.list = postModelsList;
        notifyDataSetChanged();
    }
//inner class ViewHolder
    public class PostViewHolder extends RecyclerView.ViewHolder {
        PostModels postModels;
        TextView titleTV, userTV, bodyTV;
        //constructor
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
        void bind(PostModels posts){
            this.postModels=posts;
            titleTV.setText(posts.getTitle());
            userTV.setText(posts.getUserId());
            bodyTV.setText(posts.getBody());

        }
    }

}
