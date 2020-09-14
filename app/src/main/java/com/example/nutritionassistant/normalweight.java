package com.example.nutritionassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class normalweight extends AppCompatActivity {
private TextView bf11,bf12,bf13,bf14,bf21,bf22,bf23,bf24,lh11,lh12,lh13,lh14,lh21,lh22,lh23,lh24,af11,af12,dr11,dr12,es11,es12;
private Button button;
private FirebaseAuth firebaseAuth;
private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normalweight);
        bf11=findViewById(R.id.nmplanbt11key);
        bf12=findViewById(R.id.nmplanbt11value);
        bf13=findViewById(R.id.nmplanbt12key);
        bf14=findViewById(R.id.nmplanbt12value);
        bf21=findViewById(R.id.nmplanbt13key);
        bf22=findViewById(R.id.nmplanbt13value);
        bf23=findViewById(R.id.nmplanbt14key);
        bf24=findViewById(R.id.nmplanbt14value);
        lh11=findViewById(R.id.nmplanlh11key);
        lh12=findViewById(R.id.nmplanlh11value);
        lh13=findViewById(R.id.nmplanlh12key);
        lh14=findViewById(R.id.nmplanlh12value);
        lh21=findViewById(R.id.nmplanlh13key);
        lh22=findViewById(R.id.nmplanlh13value);
        lh23=findViewById(R.id.nmplanlh14key);
        lh24=findViewById(R.id.nmplanlh14value);
        af11=findViewById(R.id.nmplanat11key);
        af12=findViewById(R.id.nmplanat11value);
        dr11=findViewById(R.id.nmplandr11key);
        dr12=findViewById(R.id.nmplandr11value);
        es11=findViewById(R.id.nmplanes11key);
        es12=findViewById(R.id.nmplanes11value);
        firebaseAuth=FirebaseAuth.getInstance();
        ref= FirebaseDatabase.getInstance().getReference("DietPlan");
        ref.child("normalweight").child("plan1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bf11.setText(dataSnapshot.child("breakfast").child("1 glass milk").getKey()+":");
                bf12.setText(dataSnapshot.child("breakfast").child("1 glass milk").getValue().toString()+"cal");
                bf13.setText(dataSnapshot.child("breakfast").child("10 raisins and 5 walnuts").getKey()+":");
                bf14.setText(dataSnapshot.child("breakfast").child("10 raisins and 5 walnuts").getValue().toString()+"cal");
                bf21.setText(dataSnapshot.child("breakfast").child("40gm oats").getKey()+":");
                bf22.setText(dataSnapshot.child("breakfast").child("40gm oats").getValue().toString()+"cal");
                bf23.setText(dataSnapshot.child("breakfast").child("5 almonds").getKey()+":");
                bf24.setText(dataSnapshot.child("breakfast").child("5 almonds").getValue().toString()+"cal");
                /*lh11.setText(dataSnapshot.child("lunch").child("1 bowl mix dal").getKey()+":");
                lh12.setText(dataSnapshot.child("lunch").child("1 bowl mix dal").getValue().toString()+"cal");
                lh13.setText(dataSnapshot.child("lunch").child("1 bowl rice").getKey()+":");
                lh14.setText(dataSnapshot.child("lunch").child("1 bowl rice").getValue().toString()+"cal");
                lh21.setText(dataSnapshot.child("lunch").child("4 roti").getKey()+":");
                lh22.setText(dataSnapshot.child("lunch").child("4 roti").getValue().toString()+"cal");
                lh23.setText(dataSnapshot.child("lunch").child("salad").getKey()+":");
                lh24.setText(dataSnapshot.child("lunch").child("salad").getValue().toString()+"cal");
                af11.setText(dataSnapshot.child("afternoon snack").child("1 apple").getKey()+":");
                af12.setText(dataSnapshot.child("afternoon snack").child("1 apple").getValue().toString()+"cal");
                dr11.setText(dataSnapshot.child("dinner").child("4 aaloo parathe").getKey()+":");
                dr12.setText(dataSnapshot.child("dinner").child("4 aaloo parathe").getValue().toString()+":");
                es11.setText(dataSnapshot.child("evening snack").child("2 oranges").getKey()+":");
                es12.setText(dataSnapshot.child("evening snack").child("2 oranges").getValue().toString()+":");*/



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
button=findViewById(R.id.nmplan1select);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        button.setText("Diet Plan Selected");
        button.setClickable(false);
    }
});
    }
}
