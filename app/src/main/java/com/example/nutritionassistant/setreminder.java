package com.example.nutritionassistant;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class setreminder extends AppCompatDialogFragment {
    private EditText title,morning_pill,afternoon_pill,night_pill,description,startdate,enddate;
    private Button button;
    private FirebaseAuth firebaseAuth;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        final View view=layoutInflater.inflate(R.layout.activity_setreminder,null);
        builder.setView(view);
        title=view.findViewById(R.id.Titlename);
        morning_pill=view.findViewById(R.id.morning);
        afternoon_pill=view.findViewById(R.id.afternoon);
        night_pill=view.findViewById(R.id.night);
        description=view.findViewById(R.id.description);
        startdate=view.findViewById(R.id.startdate);
        enddate=view.findViewById(R.id.enddate);
        button=view.findViewById(R.id.setreminder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((title.getText().toString()).isEmpty()
                        &(description.getText().toString()).isEmpty()
                        & (startdate.getText().toString()).isEmpty()
                        & (enddate.getText().toString()).isEmpty())
                {
                    Toast.makeText(getContext(),"Some fields are missing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    storereminder rem=new storereminder(title.getText().toString(),description.getText().toString(),
                            morning_pill.getText().toString(),afternoon_pill.getText().toString(),
                            night_pill.getText().toString(),startdate.getText().toString(),enddate.getText().toString());
                    firebaseAuth=FirebaseAuth.getInstance();
                    Random random=new Random();
                    FirebaseDatabase.getInstance().getReference("Reminder")
                            .child(firebaseAuth.getCurrentUser().getUid()).child("Reminder"+title.getText().toString()).setValue(rem).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getContext(),"Reminder successfully set!!!",Toast.LENGTH_LONG).show();
                                getDialog().dismiss();
                            }
                            else
                            {
                                Toast.makeText(getContext(),"Error setting reminder!!!",Toast.LENGTH_LONG).show();
                            }
                        }

                });
                }
            }
        });
        return builder.create();
    }
}

class storereminder
{
   public String title,description, morning_pill,afternoon_pill,night_pill, start_date, end_date;
    public storereminder()
    {

    }
    public storereminder(String title,String description,String morning_pill,String afternoon_pill,String night_pill,
                         String start_date,String end_date)
    {
        this.title=title;
        this.description=description;
        this.morning_pill=morning_pill;
        this.afternoon_pill=afternoon_pill;
        this.night_pill=night_pill;
        this.start_date=start_date;
        this.end_date=end_date;
    }
}