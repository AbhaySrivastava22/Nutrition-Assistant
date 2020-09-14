package com.example.nutritionassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class searchnutritionvalue extends AppCompatActivity {
    private EditText searchrecipe;
    private ImageView button;
    private FirebaseRecyclerOptions<nutritionmodel> options;
    private RecyclerView recyclerView;
    private DatabaseReference ref;
    private FirebaseRecyclerAdapter<nutritionmodel, nutritionviewholder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchnutritionvalue);
        searchrecipe = (EditText) findViewById(R.id.searchnutrition);
        button = (ImageView) findViewById(R.id.searchnutritionbutton);
        recyclerView = (RecyclerView) findViewById(R.id.nutritionrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ref = FirebaseDatabase.getInstance().getReference("Nutrition Value");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchrecipe.getText().toString();
                firebasemedicinesearch(search);
            }
        });
    }

    private void firebasemedicinesearch(String search) {
        Query firebasesearchquery = ref.orderByChild("name").startAt(search).endAt(search + "\uf8ff");
        options = new FirebaseRecyclerOptions.Builder<nutritionmodel>().setQuery(firebasesearchquery, nutritionmodel.class).build();
        adapter = new FirebaseRecyclerAdapter<nutritionmodel, nutritionviewholder>(options) {
            @NonNull
            @Override
            public nutritionviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nutritioncardview, parent, false);
                return new nutritionviewholder(v);

            }

            @Override
            protected void onBindViewHolder(@NonNull nutritionviewholder holder, int position, @NonNull nutritionmodel model) {
holder.nutriname.setText("Name:"+model.getName());
holder.nutricalorie.setText("Calories:"+model.getCalories());
holder.nutriamount.setText("Total Amount:"+model.getAmount());
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}