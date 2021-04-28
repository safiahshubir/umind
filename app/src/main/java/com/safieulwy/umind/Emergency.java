package com.safieulwy.umind;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Emergency extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView callText1,callText2,callText3,callText4,callText5;
    private Button callBtn1,callBtn2,callBtn3,callBtn4,callBtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        //define
        callText1 = findViewById(R.id.ppum);
        callText2 = findViewById(R.id.klinik);
        callText3 = findViewById(R.id.kkm);
        callText4 = findViewById(R.id.PSY);
        callText5 = findViewById(R.id.sos999);

        callBtn1 = findViewById(R.id.call_PPUM);
        callBtn2 = findViewById(R.id.call_Klinik);
        callBtn3 = findViewById(R.id.call_KMM);
        callBtn4 = findViewById(R.id.call_PSY);
        callBtn5 = findViewById(R.id.call_999);

        //clicklistener on button
        callBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton1();
            }
        });

        callBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton2();
            }
        });

        callBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton3();
            }
        });

        callBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton4();
            }
        });

        callBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton5();
            }
        });

    }

    //calling class
    private void CallButton1(){
        String number = callText1.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton2(){
        String number = callText2.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton3(){
        String number = callText3.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton4(){
        String number = callText4.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void CallButton5(){
        String number = callText5.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                CallButton1();
                CallButton2();
                CallButton3();
                CallButton4();
                CallButton5();
            }else{
                Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
        
    }
}