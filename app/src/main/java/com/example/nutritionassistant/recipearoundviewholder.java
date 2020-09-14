package com.example.nutritionassistant;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class recipearoundviewholder extends RecyclerView.ViewHolder {
    TextView name,steps,time,ingredients,calories,difficulty;
    public recipearoundviewholder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.recipearoundname);
        calories=itemView.findViewById(R.id.recipearoundcalories);
        steps=itemView.findViewById(R.id.recipearoundsteps);
        time=itemView.findViewById(R.id.recipearoundtime);
        ingredients=itemView.findViewById(R.id.recipearoundingredient);
        difficulty=itemView.findViewById(R.id.recipearoundlevel);
    }
}
