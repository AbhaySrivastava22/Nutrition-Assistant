package com.example.nutritionassistant;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class nutritionviewholder  extends RecyclerView.ViewHolder {
    public TextView nutriname,nutriamount,nutricalorie;
    public nutritionviewholder(@NonNull View itemView) {
        super(itemView);
        nutriname=itemView.findViewById(R.id.cardnutriname);
        nutriamount=itemView.findViewById(R.id.cardnutriamount);
     nutricalorie=itemView.findViewById(R.id.cardnutricalorie);
    }
}
