package com.safieulwy.umind;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button callSignUp, login_btn;
    ImageView image;
    TextView logo;
    TextInputLayout username, password;

    MediaSessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //hook
        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logoImage);
        logo = findViewById(R.id.logoName);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.Login_btn);

       // sessionManager = new MediaSessionManager(getApplicationContext());
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getEditText().getText().toString().equals("safieulwy") && password.getEditText().getText().toString().equals("password")) {
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
                else{
                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }


        });


        callSignUp.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Signup.class);

                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View,String>(image,"logo_Image");
                pairs[1] = new Pair<View,String>(logo,"logo_Name");
                pairs[2] = new Pair<View,String>(username,"username_tran");
                pairs[3] = new Pair<View,String>(password,"password_tran");
                pairs[4] = new Pair<View,String>(login_btn,"button_tran");
                pairs[5] = new Pair<View,String>(callSignUp,"login_signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                startActivity(intent,options.toBundle());

            }
        });


    }




}