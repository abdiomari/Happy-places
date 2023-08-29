package com.example.myapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityCreateContentBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateContent extends AppCompatActivity {

    Button post;
    Button imageSelect;

    FirebaseDatabase db;
    DatabaseReference reference;


    EditText editTextPlace, editTextDescription;

//activity allows data to be entered and saved to firebase
    //corresponds with activity_create_content.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);

        //TODO
        //write code to add data to db ...


        editTextPlace = findViewById(R.id.place_visited);
        editTextDescription = findViewById(R.id.description);
        imageSelect = findViewById(R.id.post_a_pic);
        post = findViewById(R.id.post);

//        Navigate back to UploadActivity after selecting an image
        imageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateContent.this, UploadActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //to post the data(place visited and description) to firebase
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title, description;
//convert data entered by user to string
                title = String.valueOf(editTextPlace
                        .getText().toString());
                description = String.valueOf(editTextDescription
                        .getText().toString());

//check if both inputs are not empty then proceed to post to firebase

                if (!title.isEmpty() && !description.isEmpty()){
                    Data data = new Data(title, description );
                    db = FirebaseDatabase.getInstance();

                    reference = db.getReference("Data");
                    reference.child(title).setValue(data)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
//                            clear the editText component after posting
                            editTextPlace.setText("");
                            editTextDescription.setText("");
                            Toast.makeText(CreateContent.this,
                                    "Happy place posted successfully!.",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
//post error message if editText is empty
                if(TextUtils.isEmpty(title)){

                    Toast.makeText(CreateContent.this,
                            "Enter a title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(description)){

                    Toast.makeText(CreateContent.this,
                            "provide a description", Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });



    }


//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 100 && resultCode == RESULT_OK && !isFinishing()){
//
//            assert data != null;
//            imageUri = data.getData();
//
//            if (firebaseImage != null){
//                firebaseImage.setImageURI(imageUri);
//            }
//        }
//
//    }

}