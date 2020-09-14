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

public class searchrecipearound extends AppCompatActivity {
    private EditText searchrecipe;
    private ImageView button;
    private FirebaseRecyclerOptions<recipearoundmodel> options;
    private RecyclerView recyclerView;
    private DatabaseReference ref;
    private FirebaseRecyclerAdapter<recipearoundmodel, recipearoundviewholder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchrecipearound);
        searchrecipe = (EditText) findViewById(R.id.searchrecipiearoundname);
        button = (ImageView) findViewById(R.id.searchrecipiearoundbutton);
        recyclerView = (RecyclerView) findViewById(R.id.myrecipearoundrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ref = FirebaseDatabase.getInstance().getReference("recipesaroundtheworld");
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
        options = new FirebaseRecyclerOptions.Builder<recipearoundmodel>().setQuery(firebasesearchquery, recipearoundmodel.class).build();
        adapter = new FirebaseRecyclerAdapter<recipearoundmodel, recipearoundviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull recipearoundviewholder holder, int position, @NonNull recipearoundmodel model) {
                holder.name.setText("Recipe Name :"+model.getName());
                holder.calories.setText("Total Calories :"+model.getCalories());
                holder.time.setText("Total Time :"+model.getTotaltime());
                holder.ingredients.setText("Ingredients :"+model.getIngredients());
                holder.steps.setText("Steps of Recipe :"+model.getStepsforrecipe());
                holder.difficulty.setText("Difficulty Level :"+model.getDifficulty());
            }

            @NonNull
            @Override
            public recipearoundviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipearoundcard, parent, false);
                return new recipearoundviewholder(v);

            }


        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
