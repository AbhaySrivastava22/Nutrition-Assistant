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

public class login extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth firebaseAuth;
    Intent intent;
    Button login;
    EditText pass;
    EditText user;
    TextView forgetpass;
    ProgressDialog dialog;


    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        login.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.user = (EditText) findViewById(R.id.email);
        this.pass = (EditText) findViewById(R.id.password);
        this.login = (Button) findViewById(R.id.login);
        this.firebaseAuth = FirebaseAuth.getInstance();
        forgetpass=(TextView)findViewById(R.id.forgetpass);
        this.login.setOnClickListener(this);
        forgetpass.setOnClickListener(this);
        dialog=new ProgressDialog(login.this);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.example.nutritionassistant.login] */
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            dialog.setMessage("Verifying emailid and password and loggin you in!!!");
            dialog.show();
            if (this.user.getText().toString().isEmpty() || this.pass.getText().toString().isEmpty()) {
                dialog.dismiss();
                alertmessage("Emailid and password is missing!!!");
            } else {
                this.firebaseAuth.signInWithEmailAndPassword(this.user.getText().toString(), this.pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if(firebaseAuth.getCurrentUser().isEmailVerified()) {
                                Intent intent = new Intent(login.this, signedin.class);
                                startActivity(intent);
                            }
                              else
                            {
                                dialog.dismiss();
                                alertmessage("First verify email and then try logging in!!!");
                            }

                        }
                        else {
                            dialog.dismiss();
                            alertmessage("Inavlid login credentials!!!");

                        }
                    }
                });
            }
        }
        if(view.getId()==R.id.forgetpass)
        {
            opendialog();
        }
    }
    public void alertmessage(String mssg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(login.this);
        builder.setMessage(mssg).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        }).show();
    }
    public void opendialog(){
        forgetpassword dialog=new forgetpassword();
        dialog.show(getSupportFragmentManager(),"SignUp Dialog");
    }
}
