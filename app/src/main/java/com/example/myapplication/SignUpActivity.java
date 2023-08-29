package com.example.myapplication;

import static com.example.myapplication.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
//    handles account creation and user registration

//    SignUpActivity binding;
//    String Name ,Username, Email, Password;
    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference reference;

    Button button;
    Button buttonRegister;

    EditText editTextEmail, editTextPassword, editTextName, editTextUsername;

    TextView textView;

    ProgressBar progressBar;



//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_sign_up);
//        button = findViewById(id.confirmButton);
        mAuth = FirebaseAuth.getInstance();
//        progressBar= findViewById(R.id.progressBar);
        editTextName = findViewById(id.name);
        editTextPassword = findViewById(id.password);
        editTextUsername = findViewById(id.uname);
        editTextEmail= findViewById(id.email);
        textView = findViewById(id.loginNow);
        buttonRegister =  findViewById(id.confirmButton);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE); }

               String name, username, email, password;

                name = String.valueOf(editTextName.getText().toString());
                username = String.valueOf(editTextUsername.getText().toString());
                email = String.valueOf(editTextEmail.getText().toString());
                password= String.valueOf(editTextPassword.getText().toString());
//upload user data to firebase after checking that all data is filled in
                if(!name.isEmpty() && !username.isEmpty() && !email.isEmpty() && !password.isEmpty())
                {
                    Users users = new Users(name,username, email, password );
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(username).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            editTextName.setText("");
                            editTextUsername.setText("");
                            editTextEmail.setText("");
                            editTextPassword.setText("");

                        }
                    });
                }
//confirm email and password are entered
                if(TextUtils.isEmpty(email)){

                    Toast.makeText(SignUpActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){

                    Toast.makeText(SignUpActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                progressBar.setVisibility(View.GONE);
                                // If sign in succeeds, display a message to the user.
                                if (task.isSuccessful()) {

                                    Toast.makeText(SignUpActivity.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), AfterLoginActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    };
}