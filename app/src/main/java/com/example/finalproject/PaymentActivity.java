package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentActivity extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance("https://final-project-a6901-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
    Button btnPlaceOrder;
    TextView txtNamePay;
    TextView txtNumPay;
    TextView txtAddPay;
    TextView txtTotalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        DatabaseReference ref = FirebaseDatabase.getInstance("https://final-project-a6901-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Users");
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        txtNamePay = findViewById(R.id.txtNamePay);
        txtNumPay = findViewById(R.id.txtNumPay);
        txtAddPay = findViewById(R.id.txtAddPay);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);

        txtNamePay.setText(UsersData.userName);
        txtAddPay.setText(UsersData.userAddress);
        txtNumPay.setText(UsersData.userNumber);

        txtTotalPrice.setText("Total: " + "PHP " + UsersData.totalValue);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FinalreceiptActivity.class);
                startActivity(i);
            }
        });
    }
}