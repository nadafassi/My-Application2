package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button callPlanning;
    Button callfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          callfragment=findViewById(R.id.call_fragment);
          callfragment.setOnClickListener(this);
          callPlanning=findViewById(R.id.call_fragment2);
        callPlanning.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
     if(v.getId()==R.id.call_fragment){
          getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentPoidIdeal()).commit();
          callfragment.setVisibility(View.GONE);
      }
     if (v.getId()==R.id.call_fragment2){
          getSupportFragmentManager().beginTransaction().replace(R.id.container,new Planning()).commit();
          callPlanning.setVisibility(View.GONE);
      }
    }


}