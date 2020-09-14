package com.example.nutritionassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signedin extends AppCompatActivity implements View.OnClickListener {
    CardView aboutus;
    CardView bmi;
    CardView dietplan;
    CardView feedback;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Intent intent;
    CardView recipe;
    CardView reminder;
    CardView search;
    CardView profile;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_signedin);
        this.profile = (CardView) findViewById(R.id.profilecall);
        this.recipe = (CardView) findViewById(R.id.recipe);
        this.bmi = (CardView) findViewById(R.id.bmi);
        this.dietplan = (CardView) findViewById(R.id.yourplan);
        this.reminder = (CardView) findViewById(R.id.reminder);
        this.aboutus = (CardView) findViewById(R.id.sigaboutus);
        this.feedback = (CardView) findViewById(R.id.sigfeedback);
        this.search = (CardView) findViewById(R.id.search);
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseUser = this.firebaseAuth.getCurrentUser();
        this.recipe.setOnClickListener(this);
        this.bmi.setOnClickListener(this);
        profile.setOnClickListener(this);
        this.dietplan.setOnClickListener(this);
        this.reminder.setOnClickListener(this);
        this.aboutus.setOnClickListener(this);
        this.feedback.setOnClickListener(this);
        this.search.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bmi /*2131230807*/:
                this.intent = new Intent(this, bmicalculator.class);
                startActivity(this.intent);
                return;
            case R.id.recipe /*2131230990*/:
               opendialog(1);
                return;
            case R.id.search:
                opendialog(2);
                break;
            case R.id.reminder:
                intent=new Intent(signedin.this, com.example.nutritionassistant.reminder.class);
                startActivity(intent);
                break;
            case R.id.sigaboutus /*2131231025*/:
                this.intent = new Intent(this, aboutus.class);
                startActivity(this.intent);
                return;
            case R.id.sigfeedback /*2131231026*/:
                this.intent = new Intent(this, feedback.class);
                startActivity(this.intent);
                return;
            case R.id.profilecall:
                intent=new Intent(signedin.this,profile.class);
                startActivity(intent);
                break;
            case R.id.yourplan:
                intent=new Intent(signedin.this,dietplan.class);
                startActivity(intent);
                break;
            default:
                return;
        }
    }

    private void opendialog(int n) {
        if (n==1){
            recipedialog dialog=new recipedialog();
            dialog.show(getSupportFragmentManager(),"SignUp Dialog");

        }
        if (n==2)
        {
            searchdialog searchdialog=new searchdialog();
            searchdialog.show(getSupportFragmentManager(),"SignUp Dialog");
        }
    }
}
