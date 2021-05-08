package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class   Register extends AppCompatActivity {
EditText mFullName,mEmail,mPassword,mPhone;
Button mRegisterBtn;
TextView mLoginBtn;

FirebaseAuth mAuth;
ProgressBar progressBar;
TextView mCreateText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullName =findViewById(R.id.fullName);
        mEmail=findViewById(R.id.Email);
        mPassword=findViewById(R.id.password);
        mPhone=findViewById(R.id.phone);
        mRegisterBtn=findViewById(R.id.register);
        mLoginBtn=findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        mCreateText=findViewById(R.id.createText);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {


              String email = mEmail.getText().toString().trim();
              String password = mPassword.getText().toString().trim();
              if (TextUtils.isEmpty(email)) {
                  mEmail.setError("Email is Required.");
                  return;
              }
              if (TextUtils.isEmpty(email)) {
                  mPassword.setError("Password is Required.");
                  return;
              }
              if(password.length()<6){
                  mPassword.setError("Password Must be >= 6 Characters");
                  return;
              }

              //register the use firebase
              mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(getApplicationContext(),Login.class));
                      }else{
                          Toast.makeText(Register.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                      }
                  }
              });


              

          }

      });

    }

    public void login(View view) {
        Intent i = new Intent(Register.this, Login.class);
        startActivity(i);

    }
}

