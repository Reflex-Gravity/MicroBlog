package com.devsvalley.microblog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewPostActivity extends AppCompatActivity {

    private EditText title;
    private EditText author;
    private EditText url;
    private EditText content;

    private Button postButton;
    private Post postModel;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference postReference = database.getReference("post");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);



        postModel =  new Post();


        title = (EditText) findViewById(R.id.title);
        author = (EditText) findViewById(R.id.author);
        url = (EditText) findViewById(R.id.picture);
        content = (EditText) findViewById(R.id.content);

        postButton = (Button) findViewById(R.id.post);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postModel.setTitle(title.getText().toString());
                postModel.setAuthor(author.getText().toString());
                postModel.setUrl(url.getText().toString());
                postModel.setContent(content.getText().toString());

                String key = postReference.push().getKey();

                postReference.child(key).setValue(postModel);
                Toast.makeText(NewPostActivity.this, "Your post is added to the blog.", Toast.LENGTH_SHORT).show();
                NewPostActivity.this.finish();


            }
        });




    }
}
