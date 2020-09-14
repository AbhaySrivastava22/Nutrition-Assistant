package com.example.nutritionassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class overweight extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overweight);
       button=(Button)findViewById(R.id.owplan1select);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               button.setText("Diet Plan Selected");
               button.setClickable(false);
           }
       });

    }
}
