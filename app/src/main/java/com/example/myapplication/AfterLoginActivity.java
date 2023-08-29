package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AfterLoginActivity extends AppCompatActivity {
//this activity manages navigation after signing in
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

//        material ui button with listener to switch back to Main Activity
        FloatingActionButton back_button = (FloatingActionButton) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Start watch content activity
                Intent intent = new Intent(AfterLoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
//       Button with listener to switch back to Watch Content Activity
        Button content_watch = (Button) findViewById(R.id.content_watch);
        content_watch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Start watch content activity
                Intent intent = new Intent(AfterLoginActivity.this, WatchContent.class);
                startActivity(intent);
                finish();
            }
        });
//       Button with listener to switch back to CreateContent Activity
        Button content_create = (Button) findViewById(R.id.content_create);
        content_create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Start create content activity
                Intent intent = new Intent(AfterLoginActivity.this, CreateContent.class);
                startActivity(intent);
                finish();
            }
        });
//       Button with listener to switch back to OpenGallery Activity
        Button view_images = (Button) findViewById(R.id.view_images);
        view_images.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Start create content activity
                Intent intent = new Intent(AfterLoginActivity.this, OpenGalleryActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }}
