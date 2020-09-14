package com.example.nutritionassistant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class bmicalculator extends AppCompatActivity {
    Button feedback;
    EditText mssg;
    EditText name;
    ProgressDialog dialog;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        bmicalculator.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator2);
        this.name = (EditText) findViewById(R.id.bmiheight);
        this.mssg = (EditText) findViewById(R.id.bmiweight);
        this.feedback = (Button) findViewById(R.id.bmicalculate);
        dialog=new ProgressDialog(bmicalculator.this);
        dialog.setMessage("Calculating BMI please wait!!!");
        this.feedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                dialog.show();
                String BMI_Category;
                String hei = bmicalculator.this.name.getText().toString();
                double bm = ((double) (Integer.parseInt(bmicalculator.this.mssg.getText().toString()) * 10000)) / (Double.parseDouble(hei) * Double.parseDouble(hei));
                String bmi = Double.toString(bm);
                if (bm < 18.5d) {
                    BMI_Category = "UnderWeight";
                } else if (bm >= 18.5d && bm <= 24.9d) {
                    BMI_Category = "NormalWeight";
                } else if (bm < 25.0d || bm > 29.9d) {
                    BMI_Category = "Obesity";
                } else {
                    BMI_Category = "OverWeight";
                }
                dialog.dismiss();
                Intent intent = new Intent(bmicalculator.this, bmidisplay.class);
                intent.putExtra("message", "The BMI is " + bmi + "\nThe BMI Category is " + BMI_Category);
                bmicalculator.this.startActivity(intent);
            }
        });
    }
}
