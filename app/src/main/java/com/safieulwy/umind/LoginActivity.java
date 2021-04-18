package com.safieulwy.umind;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    Button callSignUp, login_btn;
    ImageView image;
    TextView logo;
    TextInputLayout username, password;

   // MediaSessionManager sessionManager;

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
  /*      login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getEditText().getText().toString().equals("safieulwy") && password.getEditText().getText().toString().equals("password")) {
                    Intent intent = new Intent(LoginActivity.this, Home.class);
                    startActivity(intent);
                }
                else{
                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }


        });*/

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Signup.class);

                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View,String>(image,"logo_Image");
                pairs[1] = new Pair<View,String>(logo,"logo_Name");
                pairs[2] = new Pair<View,String>(username,"username_tran");
                pairs[3] = new Pair<View,String>(password,"password_tran");
                pairs[4] = new Pair<View,String>(login_btn,"button_tran");
                pairs[5] = new Pair<View,String>(callSignUp,"login_signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,options.toBundle());

            }
        });


    }

    private Boolean validateUsername(){
        String val = username.getEditText().getText().toString();

        if (val.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = password.getEditText().getText().toString();

        if (val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private void loginUser(View view){
        //validate login info
        if (!validateUsername() | !validatePassword()){
            return;
        } else{
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredUsername = username.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child (userEnteredUsername).child("password").getValue(String.class);

                    if(passwordFromDB.equals(userEnteredPassword)){

                        password.setError(null);
                        password.setErrorEnabled(false);

                        String nameFromDB = dataSnapshot.child (userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child (userEnteredUsername).child("username").getValue(String.class);
                        String phoneNoFromDB = dataSnapshot.child (userEnteredUsername).child("phoneNo").getValue(String.class);
                        String emailFromDB = dataSnapshot.child (userEnteredUsername).child("email").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),UserProfile.class);

                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phoneNo", phoneNoFromDB);
                        intent.putExtra("password", passwordFromDB);

                        startActivity(intent);

                    }
                    else{
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                }
                else{
                    username.setError("No such User exist");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
               // Toast.makeText(context:LoginActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}