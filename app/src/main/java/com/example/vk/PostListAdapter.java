package com.example.vk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    ImageView imgAva;
    TextView likes;
    ImageView img;
    TextView desc;
    TextView name;
    TextView date;
    ImageButton imgLike;

    private List<Post> postList;
    Context context;
    @Nullable
    private ItemClickListener listener;

    public PostListAdapter(List<Post> postList){
        this.postList = postList;
    }

    public PostListAdapter(List<Post> postList, @Nullable ItemClickListener listener, Context context){
        this.postList=postList;
        this.context=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new PostViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder holder, final int position) {
        final Post post = postList.get(position);
        holder.name.setText(post.getName());
        holder.date.setText(post.getDate());
        holder.likes.setText(post.getLikes()+"");
        holder.imgAva.setImageResource(R.drawable.sportava1);

        holder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "Liked", Toast.LENGTH_LONG).show();

                holder.imgLike.setImageResource(R.drawable.liked);

                if (listener != null) {
                    listener.itemLike(position, post);
                }


            }
        });

        if(post.getLike()==true){
            holder.imgLike.setImageResource(R.drawable.liked);
        }
        else{
            holder.imgLike.setImageResource(R.drawable.like);
        }
                Glide.with(holder.img.getContext())
                        .load(post.getImg())
                        .into(holder.img);
        holder.desc.setText(post.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, post);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAva;
        TextView likes;
        ImageView img;
        TextView desc;
        TextView name;
        TextView date;
        ImageButton imgLike;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAva = itemView.findViewById(R.id.imgAva);
            img = itemView.findViewById(R.id.cartinka);
            desc = itemView.findViewById(R.id.desc);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            imgLike = itemView.findViewById(R.id.imgLike);
            likes = itemView.findViewById(R.id.likes);

        }
    }

    interface ItemClickListener {
        void itemClick(int position, Post item);
        void itemLike(int position, Post item);
    }

}
