package com.example.nutritionassistant;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class fooditemviewholder extends RecyclerView.ViewHolder {
    public TextView foodname,cookedmeasure,cookedweight,foodcalorie;
    public fooditemviewholder(@NonNull View itemView) {
        super(itemView);
        foodname=itemView.findViewById(R.id.cardfoodname);
        cookedmeasure=itemView.findViewById(R.id.cardfoodmeasure);
        foodcalorie=itemView.findViewById(R.id.cardfoodcalorie);
        cookedweight=itemView.findViewById(R.id.cardfoodweight);
    }
}
