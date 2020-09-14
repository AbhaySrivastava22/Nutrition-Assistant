package com.example.nutritionassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Button login;
    Button signup;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        MainActivity.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.login = (Button) findViewById(R.id.logincall);
        this.signup = (Button) findViewById(R.id.signupcall);
        this.login.setOnClickListener(this);
        this.signup.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.logincall) {
            this.intent = new Intent(this, login.class);
            startActivity(this.intent);
        } else if (id == R.id.signupcall) {
            this.intent = new Intent(this, signup.class);
            startActivity(this.intent);
        }
    }
}
