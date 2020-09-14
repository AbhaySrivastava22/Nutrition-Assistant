package com.example.nutritionassistant;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {
    /* access modifiers changed from: protected */

    private DatabaseReference databaseReference;
    private ImageView imageView;
    private TextView name,emailid,dob,country,state,height,weight,bmi,category,disease,allergy,gender;
    private Button logout;
    private FirebaseAuth firebaseAuth;
    public void onCreate(Bundle savedInstanceState) {
        profile.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView=(ImageView)findViewById(R.id.profiledp);
        name=(TextView)findViewById(R.id.profilename);
        emailid=(TextView)findViewById(R.id.profileemail);
        dob=(TextView)findViewById(R.id.profiledob);
        country=(TextView)findViewById(R.id.profilecou);
        state=(TextView)findViewById(R.id.profilestate);
        height=(TextView)findViewById(R.id.profileheight);
        weight=(TextView)findViewById(R.id.profileweight);
        bmi=(TextView)findViewById(R.id.profilebmi);
        category=(TextView)findViewById(R.id.profilecat);
        disease=(TextView)findViewById(R.id.profiledisease);
        allergy=(TextView)findViewById(R.id.profileall);
        gender=(TextView)findViewById(R.id.profilegender);
        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent intent=new Intent(profile.this,MainActivity.class);
                startActivity(intent);
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("UserDetails");
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(getApplicationContext(), dataSnapshot.child("date").getValue().toString(),Toast.LENGTH_LONG).show();
                name.setText(dataSnapshot.child("name").getValue().toString());
                emailid.setText(dataSnapshot.child("emailid").getValue().toString());
                dob.setText(dataSnapshot.child("date").getValue().toString());
                country.setText(dataSnapshot.child("country").getValue().toString());
                state.setText(dataSnapshot.child("state").getValue().toString());
                height.setText(dataSnapshot.child("height").getValue().toString());
                weight.setText(dataSnapshot.child("weight").getValue().toString());
                bmi.setText(dataSnapshot.child("bmi").getValue().toString());
                category.setText(dataSnapshot.child("BMI_Category").getValue().toString());
                gender.setText(dataSnapshot.child("gender").getValue().toString());
                if(dataSnapshot.child("disease").getValue().toString().isEmpty())
                {
                    disease.setText("No Disease");
                }
                else
                {
                    disease.setText(dataSnapshot.child("disease").getValue().toString());
                }
                if(dataSnapshot.child("allergy").getValue().toString().isEmpty())
                {
                    allergy.setText("No Allergy");
                }
                else
                {
                    allergy.setText(dataSnapshot.child("allergy").getValue().toString());
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialog();
            }
        });

    }
    public void opendialog(){
        imageuploader dialog=new imageuploader();
        dialog.show(getSupportFragmentManager(),"SignUp Dialog");
    }
}
