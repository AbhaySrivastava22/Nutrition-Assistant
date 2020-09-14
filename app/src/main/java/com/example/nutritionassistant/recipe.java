package com.example.nutritionassistant;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class recipe extends AppCompatActivity {
    DatabaseReference databaseReference;
    Button feedback;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Intent intent;
    EditText mssg;
    EditText name;
    EditText recipetime;
    EditText recipe;
ProgressDialog dialog;
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        recipe.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        this.name = (EditText) findViewById(R.id.recname);
        this.mssg = (EditText) findViewById(R.id.recstep);
        this.recipe = (EditText) findViewById(R.id.recing);
        recipetime=(EditText)findViewById(R.id.estimatedtime);
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Recipe");
        this.feedback = (Button) findViewById(R.id.submitrecipe);
        dialog=new ProgressDialog(recipe.this);
        FirebaseUser currentUser = this.firebaseAuth.getCurrentUser();
        this.feedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.setMessage("Submitting your recipe please wait!!!");
                dialog.show();
                Recipechild recipes=new Recipechild(name.getText().toString(),mssg.getText().toString(),recipe.getText().toString(),
                        recipetime.getText().toString());
                FirebaseDatabase.getInstance().getReference("Recipes").child(name.getText().toString()+"recipe").setValue(recipes).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                    /* JADX WARNING: type inference failed for: r0v2, types: [android.content.Context, com.example.nutritionassistant.recipe] */
                    /* JADX WARNING: type inference failed for: r0v5, types: [android.content.Context, com.example.nutritionassistant.recipe] */
                    /* JADX WARNING: type inference failed for: r2v3, types: [android.content.Context, com.example.nutritionassistant.recipe] */
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            dialog.dismiss();
                            Toast.makeText(recipe.this, "Recipe Submitted Successfully",Toast.LENGTH_SHORT).show();
                            recipe.this.intent = new Intent(recipe.this, signedin.class);
                            recipe.this.startActivity(recipe.this.intent);
                            return;
                        }
                        else
                        {
                            dialog.dismiss();
                            alertmessage("Error submitting recipe!!!");
                        }
                    }
                });
            }
        });
    }
    public void alertmessage(String mssg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(recipe.this);
        builder.setMessage(mssg).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        }).show();
    }
}
class Recipechild {
   public String ingredients,name,stepsofrecipe,totaltime;
    public Recipechild()
    {

    }

    public Recipechild(String nm, String ms, String res,String restime) {
        this.name = nm;
        this.stepsofrecipe = ms;
        this.ingredients = res;
        this.totaltime=restime;
    }
}