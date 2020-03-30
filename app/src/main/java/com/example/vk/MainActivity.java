package com.example.vk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import static com.example.vk.AllItems.items;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private PostListAdapter adapter;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private static Bundle mBundleRecyclerViewState;

    private PostListAdapter.ItemClickListener listener = null;
    boolean isLiked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listener = new PostListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, Post item) {
                Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("post", (Parcelable) item);
                startActivity(intent);
            }



            @Override
            public void itemLike(int position, Post item) {
                isLiked=item.getLike();
                if (item.getLike()==false){
                    item.setLike(true);
                    item.setLikes(item.getLikes()+1);
                    isLiked=true;
                }else {
                    item.setLikes(item.getLikes()-1);
                    item.setLike(false);
                    isLiked=false;
                }
                adapter.notifyItemChanged(position);
            }
        };

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PostListAdapter(postGenerator(), listener, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mBundleRecyclerViewState = new Bundle();
        // save RecyclerView statele();
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // restore RecyclerView state
        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        }
    }

    private List<Post> postGenerator() {
      items = items;
        return items;
    }
}
