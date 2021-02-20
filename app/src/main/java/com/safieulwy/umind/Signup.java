package com.safieulwy.umind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
//variable
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
   // Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //hooks
        regName = findViewById(R.id.reg_name);
        regUsername =  findViewById(R.id.reg_username);
        regEmail =   findViewById(R.id.reg_email);
        regPhoneNo =   findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn =  findViewById(R.id.reg_btn);
        regToLoginBtn =  findViewById(R.id.reg_login_btn);
       // callSignIn = findViewById(R.id.login_screen);
       // users = new Users();

        //save data firebase
        regBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");

//Get all the values
                String name = regName.getEditText().getText().toString().trim();
                String username = regUsername.getEditText().getText().toString().trim();
                String email = regEmail.getEditText().getText().toString().trim();
                String phoneNo = regPhoneNo.getEditText().getText().toString().trim();
                String password = regPassword.getEditText().getText().toString().trim();

                Users users = new Users(name, username, email, phoneNo, password);
                reference.child(username).setValue(users);

                Toast.makeText(Signup.this, "Register Succesfully", Toast.LENGTH_LONG).show();
            }
        });//Register Button method end
    }//onCreate Method End
}