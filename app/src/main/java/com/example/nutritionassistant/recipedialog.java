package com.example.nutritionassistant;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class recipedialog extends AppCompatDialogFragment implements View.OnClickListener {
    private Button addrecipe, userrecipe, reciperound;
    Intent intent;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        final View view=layoutInflater.inflate(R.layout.recipedialog,null);
        builder.setView(view);
        addrecipe=view.findViewById(R.id.addrecipe);
        userrecipe=view.findViewById(R.id.userrecipe);
        reciperound=view.findViewById(R.id.recipesaroundtheworld);
        addrecipe.setOnClickListener(this);
        userrecipe.setOnClickListener(this);
        reciperound.setOnClickListener(this);
        return builder.create();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addrecipe:
                intent = new Intent(getActivity().getApplication(), recipe.class);
                startActivity(intent);
                break;
            case R.id.userrecipe:
                intent = new Intent(getActivity().getApplication(), searchuserrecipe.class);
                startActivity(intent);
                break;
            case R.id.recipesaroundtheworld:
                intent = new Intent(getActivity().getApplication(), searchrecipearound.class);
                startActivity(intent);
                break;
        }
    }
}
