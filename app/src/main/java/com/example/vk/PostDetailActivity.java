package com.example.vk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PostDetailActivity extends AppCompatActivity{

    private TextView text;
    private ImageView img;
    private TextView name;
    private TextView date;
    private ImageButton imgLike;
    private TextView likes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Post post = (Post) getIntent().getParcelableExtra("post");
        text = findViewById(R.id.text);
        img = findViewById(R.id.img);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        imgLike = findViewById(R.id.imgLike);
        likes = findViewById(R.id.likes);

        img.setImageResource(post.getImg());
        text.setText(post.getDescription());
        name.setText(post.getName());
        date.setText(post.getDate());
        imgLike.setImageResource(post.getImgLike());
        likes.setText(post.getLikes()+"");


    }
}
