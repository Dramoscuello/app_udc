package com.dramoscuello.udc_social;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{


    private Button buttonLogout;
    private TextView textViewUser;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        FirebaseUser user  = firebaseAuth.getCurrentUser();
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        textViewUser = (TextView) findViewById(R.id.textViewUser);
        textViewUser.setText("Bienvenido: " + user.getEmail());
        buttonLogout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
