package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    Button button;

    Button buttonLogin;

    EditText editTextEmail, editTextPassword;

    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    public void onStart(){
        super.onStart();
//        check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainPageActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
//        progressBar= findViewById(R.id.progressBar);
        buttonLogin = findViewById(R.id.loginButton);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        button = findViewById(R.id.signupButton);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(intent);
            finish();

        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view){
                if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);}
                String email, password;
                email = String.valueOf(editTextEmail.getText().toString());
                password = String.valueOf(editTextPassword.getText().toString());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (progressBar != null) {
                        progressBar.setVisibility(View.GONE);}
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainPageActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Login Unsuccessful. Check Details",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });
    }
}











































