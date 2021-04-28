package com.safieulwy.umind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private CardView stressBuster,knowledgeBytes,emergency,accSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // define card
        stressBuster = (CardView)findViewById(R.id.stress_buster);
        knowledgeBytes = (CardView)findViewById(R.id.knowledge_bytes);
        emergency = (CardView)findViewById(R.id.emergency);
        accSettings = (CardView) findViewById(R.id.acc_settings);

        //add clicklistener
        stressBuster.setOnClickListener(this);
        knowledgeBytes.setOnClickListener(this);
        emergency.setOnClickListener(this);
        accSettings.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.stress_buster : i = new Intent(this,StressBuster.class); startActivity(i); break;
            case R.id.knowledge_bytes : i = new Intent(this,KnowledgeBytes.class); startActivity(i); break;
            case R.id.emergency : i = new Intent(this,Emergency.class); startActivity(i); break;
            case R.id.acc_settings : i = new Intent(this,AccSettings.class); startActivity(i); break;
            default: break;
        }

    }
}