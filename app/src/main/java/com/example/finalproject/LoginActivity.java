package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtName, txtNumb, txtPassword;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://final-project-a6901-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Users");
    String name;
    String number;
    String password;
    String rname;
    String rnumber;
    String rpassword;
    boolean userExist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogIn);
        txtName = findViewById(R.id.txtName);
        txtNumb = findViewById(R.id.txtNumb);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = txtNumb.getText().toString();
                name = txtName.getText().toString();
                password = txtPassword.getText().toString();
                ref.child(number).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        rnumber = snapshot.child("number").getValue(String.class);
                        rname = snapshot.child("name").getValue(String.class);
                        rpassword = snapshot.child("password").getValue(String.class);
                        if(name.equals(rname)&&number.equals(rnumber)&&password.equals(rpassword)) {
                            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                            UsersData.userNumber = number;
                            UsersData.userName = name;
                            UsersData.userAddress = snapshot.child("address").getValue(String.class);
                            UsersData.userEmail = snapshot.child("email").getValue(String.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}