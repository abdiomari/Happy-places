package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class AfterLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Start watch content activity
                Intent intent = new Intent(AfterLoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

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

    }}
