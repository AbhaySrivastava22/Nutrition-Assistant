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

public class searchuserrecipe extends AppCompatActivity {
    private FirebaseRecyclerOptions<recipemodel> options;
    private RecyclerView recyclerView;
    private DatabaseReference ref;
    private FirebaseRecyclerAdapter<recipemodel,recipieviewholder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchuserrecipe);
        recyclerView=(RecyclerView)findViewById(R.id.myreciperecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ref= FirebaseDatabase.getInstance().getReference("Recipes");
        options=new FirebaseRecyclerOptions.Builder<recipemodel>().setQuery(ref,recipemodel.class).build();
        adapter= new FirebaseRecyclerAdapter<recipemodel, recipieviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull recipieviewholder holder, int position, @NonNull recipemodel model) {
                holder.name.setText("Recipe Name :"+model.getName());
                holder.time.setText("Total Time :"+model.getTotaltime());
                holder.ingredients.setText("Ingredients :"+model.getIngredients());
                holder.steps.setText("Steps of Recipe :"+model.getStepsofrecipe());

            }

            @NonNull
            @Override
            public recipieviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.userrecipeview,parent,false);
                return new recipieviewholder(v);
            }


        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
