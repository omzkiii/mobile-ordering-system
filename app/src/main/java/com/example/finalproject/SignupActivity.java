package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupActivity extends AppCompatActivity {
    Button btnSignUp;
    EditText txtName, txtNumber, txtAddress, txtEmail, txtPassword;
    DatabaseReference ref;
    UsersData users;
    boolean userExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignUp = findViewById(R.id.btnSignUp);
        txtName = findViewById(R.id.txtName);
        txtNumber = findViewById(R.id.txtNumber);
        txtAddress = findViewById(R.id.txtAddress);
        txtEmail = findViewById(R.id.txtNum);
        txtPassword = findViewById(R.id.txtPassword);
        ref = FirebaseDatabase.getInstance("https://final-project-a6901-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Users");
        users = new UsersData();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = (txtName.getText().toString());
                String number = (txtNumber.getText().toString());
                String address = (txtAddress.getText().toString());
                String email = (txtEmail.getText().toString());
                String password = (txtPassword.getText().toString());
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(
                                name.isEmpty()||
                                        address.isEmpty()||
                                        email.isEmpty()||
                                        password.toString().isEmpty())
                            Toast.makeText(SignupActivity.this,"Please Fill Up The Form", Toast.LENGTH_SHORT).show();
                        else if(snapshot.child(number).exists()){
                            Toast.makeText(SignupActivity.this, "Number is already registered", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            ref.child(number).child("name").setValue(name);
                            ref.child(number).child("number").setValue(number);
                            ref.child(number).child("address").setValue(address);
                            ref.child(number).child("email").setValue(email);
                            ref.child(number).child("password").setValue(password);
                            UsersData.userNumber = number;
                            UsersData.userName = name;
                            UsersData.userAddress = address;
                            UsersData.userEmail = email;

                            Toast.makeText(SignupActivity.this, "Signed Up", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(i);
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