package com.example.nutritionassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class dietplan extends AppCompatActivity implements View.OnClickListener {
private TextView bmr_display,calorie_display,bmicat;
private Button getdiet,creatediet;
private FirebaseAuth firebaseAuth;
public String b;
private  Intent intent;
private DatabaseReference databaseReference;
private Double Bmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplan);
        bmr_display=(TextView)findViewById(R.id.bmrdisplay);
        calorie_display=(TextView)findViewById(R.id.caloriesday);
        getdiet=(Button)findViewById(R.id.get_owndietplan);
        //creatediet=(Button)findViewById(R.id.create_dietplan);
        bmicat=(TextView)findViewById(R.id.bmicat);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("UserDetails");
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String height=dataSnapshot.child("height").getValue().toString();
               Double h=Double.parseDouble(height);
               String weight=dataSnapshot.child("weight").getValue().toString();
               Double w=Double.parseDouble(weight);
               String age=dataSnapshot.child("date").getValue().toString();
               Double ag=Double.parseDouble(age);
                if(dataSnapshot.child("gender").getValue().toString().toLowerCase().trim()=="female") {
                    Bmr =(10*w)+(6.25*h)-(5*ag)-161;
                    calorie_display.setText("Calories required per day"+Bmr.toString());
                }
                else
                {
                     Bmr =(10*w)+(6.25*h)-(5*ag)-161;
                    calorie_display.setText("Calories required per day"+Bmr.toString());
                }
                bmr_display.setText("Your BMI is:"+dataSnapshot.child("bmi").getValue().toString());
                bmicat.setText("Your BMI category is:"+dataSnapshot.child("BMI_Category").getValue().toString());
                b=dataSnapshot.child("BMI_Category").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        getdiet.setOnClickListener(this);
        //creatediet.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.get_owndietplan:
                if(b=="NormalWeight") {
                    intent = new Intent(dietplan.this, normalweight.class);
                }
                else if(b=="UnderWeight")
                {
                    intent = new Intent(dietplan.this, underweight.class);
                }
                else
                {
                    intent = new Intent(dietplan.this, overweight.class);
                }
                startActivity(intent);
        }

    }
}
