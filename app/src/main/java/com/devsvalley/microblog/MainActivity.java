package com.devsvalley.microblog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference postReference = database.getReference("post");

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.post_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        FirebaseRecyclerAdapter<Post,PostViewHolder> adapter = new FirebaseRecyclerAdapter<Post, PostViewHolder>(Post.class, R.layout.item_post, PostViewHolder.class, postReference.orderByChild("url") ) {
            @Override
            protected void populateViewHolder(PostViewHolder viewHolder, Post model, int position) {

                viewHolder._author.setText(model.getAuthor());
                viewHolder._content.setText(model.getContent());
                viewHolder._title.setText(model.getTitle());
                Picasso.with(MainActivity.this).load(model.getUrl()).fit().centerCrop().into(viewHolder._coverPicture);

            }
        };

        recyclerView.setAdapter(adapter);











        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, NewPostActivity.class));



            }
        });
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{

        private ImageView _coverPicture;
        private TextView _title;
        private TextView _author;
        private TextView _content;


        public PostViewHolder(View itemView) {
            super(itemView);

            _coverPicture = (ImageView) itemView.findViewById(R.id.cover);
            _title = (TextView) itemView.findViewById(R.id.title);
            _author = (TextView) itemView.findViewById(R.id.author);
            _content = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
