package com.example.nutritionassistant;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class searchdialog extends AppCompatDialogFragment implements View.OnClickListener{
    private Button searchfood, nutrition;
    Intent intent;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        final View view=layoutInflater.inflate(R.layout.searchdialog,null);
        builder.setView(view);
        searchfood=view.findViewById(R.id.searchfooditem);
        nutrition=view.findViewById(R.id.searchnutrition);
        searchfood.setOnClickListener(this);
        nutrition.setOnClickListener(this);
        return builder.create();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchnutrition:
                intent = new Intent(getActivity().getApplication(), searchnutritionvalue.class);
                startActivity(intent);
                break;
            case R.id.searchfooditem:
                intent = new Intent(getActivity().getApplication(), searchfooditems.class);
                startActivity(intent);
                break;

        }
    }
}

