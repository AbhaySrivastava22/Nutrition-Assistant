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

public class searchfooditems extends AppCompatActivity {
    private EditText searchrecipe;
    private ImageView button;
    private FirebaseRecyclerOptions<fooditemmodel> options;
    private RecyclerView recyclerView;
    private DatabaseReference ref;
    private FirebaseRecyclerAdapter<fooditemmodel, fooditemviewholder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchfooditems);
        searchrecipe = (EditText) findViewById(R.id.searchfooditem);
        button = (ImageView) findViewById(R.id.searchfooditembutton);
        recyclerView = (RecyclerView) findViewById(R.id.fooditemrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ref = FirebaseDatabase.getInstance().getReference("Food Item");
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
        options = new FirebaseRecyclerOptions.Builder<fooditemmodel>().setQuery(firebasesearchquery, fooditemmodel.class).build();
        adapter = new FirebaseRecyclerAdapter<fooditemmodel, fooditemviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull fooditemviewholder holder, int position, @NonNull fooditemmodel model) {
                holder.foodname.setText("Name:"+model.getName());
                holder.foodcalorie.setText("Calories:"+model.getCalories());
                holder.cookedweight.setText("Cooked Weight:"+model.getCooked_weight());
                holder.cookedmeasure.setText("Cooked Weight:"+model.getCooked_measure());

            }

            @NonNull
            @Override
            public fooditemviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditemcardview, parent, false);
                return new fooditemviewholder(v);

            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
