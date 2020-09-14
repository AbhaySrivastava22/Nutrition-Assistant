package com.example.nutritionassistant;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class bmidisplay extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        bmidisplay.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmidisplay);
        ((TextView) findViewById(R.id.bmidisplay)).setText(getIntent().getExtras().getString("message"));
    }
}
