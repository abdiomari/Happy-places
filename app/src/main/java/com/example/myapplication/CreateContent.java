package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
    Uri imageUri;
    ProgressDialog progressDialog;

    ImageView firebaseImage;

    StorageReference storageReference;


    FirebaseDatabase db;
    DatabaseReference reference;


    EditText editTextPlace, editTextDescription;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);

        //TODO
        //write code to add data to db ...
        //write code to  take photos......
        //write code to upload photos.....
        //store photos on firebase.......

        editTextPlace = findViewById(R.id.place_visited);
        editTextDescription = findViewById(R.id.description);
        imageSelect = findViewById(R.id.post_a_pic);
        post = findViewById(R.id.post);
        firebaseImage= findViewById(R.id.firebaseImage);

        //to upload an image from the device
        imageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        //to post the data to firebase
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
                String title, description;

                title = String.valueOf(editTextPlace
                        .getText().toString());
                description = String.valueOf(editTextDescription
                        .getText().toString());

                if (!title.isEmpty() && !description.isEmpty()){
                    Data data = new Data(title, description);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Data");
                    reference.child(title).setValue(data)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            editTextPlace.setText("");
                            editTextDescription.setText("");

                            Toast.makeText(CreateContent.this,
                                    "Happy place posted successfully!.",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }

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

    private void uploadImage() {

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("uploading file...");
//        progressDialog.show();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.ENGLISH);
        Date now = new Date();
        String fileName = formatter.format(now);

        if (imageUri != null) {
            StorageReference storageReference = FirebaseStorage.getInstance().getReference("images/" + fileName);
            StorageReference imageRef = storageReference.child(imageUri.getLastPathSegment());

           UploadTask uploadTask = imageRef.putFile(imageUri);
           uploadTask
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            firebaseImage.setImageURI(imageUri);

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Toast.makeText(CreateContent.this,
                                    "Image not uploaded", Toast.LENGTH_SHORT).show();

                        }
                    });
        }
    }

    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 100);
//        registerForActivityResult(intent, 100);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 100 && data != null){
            imageUri = data.getData();
            firebaseImage.setImageURI(imageUri);

        }

    }
}