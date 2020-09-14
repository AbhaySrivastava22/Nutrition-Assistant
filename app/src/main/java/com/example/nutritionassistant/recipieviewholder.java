package com.example.nutritionassistant;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recipieviewholder extends RecyclerView.ViewHolder {
    TextView name,steps,time,ingredients;
    public recipieviewholder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.cardrecipename);
        steps=itemView.findViewById(R.id.recipesteps);
        time=itemView.findViewById(R.id.cardrecipetime);
        ingredients=itemView.findViewById(R.id.recipeingredient);

    }
}
