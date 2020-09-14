package com.example.nutritionassistant;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText allergy;
    Button button;
    EditText compass;
    EditText country;
    DatabaseReference databaseReference;
    EditText disease;
    EditText dob;
    EditText emailid;
    FirebaseAuth firebaseAuth;
    EditText fullname;
    EditText height;
    EditText pass;
    EditText state;
    EditText weight;
    EditText gender;
    ProgressDialog dialog;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        signup.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        gender=(EditText) findViewById(R.id.signupgender);
        fullname = (EditText) findViewById(R.id.fullname);
        dob = (EditText) findViewById(R.id.dob);
        country = (EditText) findViewById(R.id.country);
        state = (EditText) findViewById(R.id.state);
        emailid = (EditText) findViewById(R.id.emailid);
        pass = (EditText) findViewById(R.id.nutpassword);
        compass = (EditText) findViewById(R.id.conpassword);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        disease = (EditText) findViewById(R.id.disease);
        allergy = (EditText) findViewById(R.id.allergy);
        button = (Button) findViewById(R.id.signuppage);
        firebaseAuth = FirebaseAuth.getInstance();
        dialog=new ProgressDialog(signup.this);
        databaseReference = FirebaseDatabase.getInstance().getReference("UserDetails");
        button.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.content.Context, com.example.nutritionassistant.signup] */
            /* JADX WARNING: type inference failed for: r0v7, types: [android.content.Context, com.example.nutritionassistant.signup] */
            /* JADX WARNING: type inference failed for: r0v49, types: [android.content.Context, com.example.nutritionassistant.signup] */
            public void onClick(View view) {
                dialog.setMessage("Registration in process please wait !!!");
                dialog.show();
                if (fullname.getText().toString().isEmpty() & dob.getText().toString().isEmpty()
                        &country.getText().toString().isEmpty()
                        &state.getText().toString().isEmpty()
                        &emailid.getText().toString().isEmpty()
                        &pass.getText().toString().isEmpty()
                        &height.getText().toString().isEmpty()
                        &weight.getText().toString().isEmpty()&gender.getText().toString().isEmpty()) {
                    alertmessage("Some fields are missing!!!");
                } else if (pass.getText().toString().equals(compass.getText().toString())) {
                    firebaseAuth.createUserWithEmailAndPassword(emailid.getText().toString(), pass.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        public void onComplete(@NonNull Task<AuthResult> task) {
                            String BMI_Category;
                            if (task.isSuccessful()) {
                                String name = fullname.getText().toString();
                                String gen=gender.getText().toString();
                                String date =dob.getText().toString();
                                String coun =country.getText().toString();
                                String sta = state.getText().toString();
                                String hei = height.getText().toString();
                                String wei = weight.getText().toString();
                                String dis = disease.getText().toString();
                                String all = allergy.getText().toString();
                                String em = emailid.getText().toString();
                                String obj = pass.getText().toString();
                                double bm = ((double) (Integer.parseInt(wei) * 10000)) / (Double.parseDouble(hei) * Double.parseDouble(hei));
                                String bmi = Double.toString(bm);
                                if (bm < 18.5d) {
                                    BMI_Category = "UnderWeight";
                                } else if (bm >= 18.5d && bm <= 24.9d) {
                                    BMI_Category = "NormalWeight";
                                } else if (bm < 25.0d || bm > 29.9d) {
                                    BMI_Category = "Obesity";
                                } else {
                                    BMI_Category = "OverWeight";
                                }
                                nutrition user=new nutrition(name, date, coun, sta, hei, wei, em, bmi, all, dis, BMI_Category,gen);
                                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(user).
                                        addOnCompleteListener(new OnCompleteListener<Void>() {

                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            firebaseAuth.getCurrentUser().sendEmailVerification().
                                                    addOnCompleteListener(signup.this, new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                    dialog.dismiss();
                                                                    Toast.makeText(signup.this, "Registered Successfully and verification " +
                                                                            "email has been sent!!!", Toast.LENGTH_LONG).show();
                                                                    Intent intent = new Intent(signup.this, login.class);
                                                                    startActivity(intent);


                                                            } else {
                                                                alertmessage("Error Sending Verification Email !!");
                                                            }

                                                        }
                                                    });
                                        } else {
                                            dialog.dismiss();
                                            alertmessage("Registration failed due to some fatal error!!");
                                        }
                                    }
                                });

                            }

                        }
                    });
                } else {
                    dialog.dismiss();
                    alertmessage("Password mismatch!!!");
                }
            }
        });
    }
    public void alertmessage(String mssg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(signup.this);
        builder.setMessage(mssg).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        }).show();
    }
}
class nutrition {
   public String BMI_Category;
   public String allergy;
  public   String bmi;
   public String country;
   public String date;
    public String disease;
    public String emailid;
    public String height;
    public String name;
    public String state;
    public String weight;
    public String gender;
    public nutrition()
{

}
    public nutrition(String nm, String dt, String count, String st, String ht, String wt, String em, String bm, String aller, String dis, String bmc,String gender) {
        this.name = nm;
        this.date = dt;
        this.country = count;
        this.state = st;
        this.height = ht;
        this.weight = wt;
        this.emailid = em;
        this.bmi = bm;
        this.allergy = aller;
        this.disease = dis;
        this.BMI_Category = bmc;
        this.gender=gender;
    }
}
