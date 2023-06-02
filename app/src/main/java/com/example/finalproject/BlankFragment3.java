package com.example.finalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BlankFragment3 extends Fragment {

    Button btnCDMin, btnCNDMin, btnEBMin, btnFBMin, btnGDMin, btnCBMin, btnCDAdd, btnCNDAdd, btnEBAdd, btnFBAdd, btnGDAdd, btnCBAdd;
    @SuppressLint("StaticFieldLeak")
    public static TextView txtCD, txtCND, txtEB, txtFB, txtGD, txtCB;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank3, container, false);
        btnCDAdd = (Button) view.findViewById(R.id.cd_add_btn);
        btnCNDAdd = (Button) view.findViewById(R.id.cnd_add_btn);
        btnEBAdd = (Button) view.findViewById(R.id.eb_add_btn);
        btnFBAdd = (Button) view.findViewById(R.id.fb_add_btn);
        btnGDAdd = (Button) view.findViewById(R.id.gd_add_btn);
        btnCBAdd = (Button) view.findViewById(R.id.cb_add_btn);

        btnCDMin = (Button) view.findViewById(R.id.cd_min_btn);
        btnCNDMin = (Button) view.findViewById(R.id.cnd_min_btn);
        btnEBMin = (Button) view.findViewById(R.id.eb_min_btn);
        btnFBMin = (Button) view.findViewById(R.id.fb_min_btn);
        btnGDMin = (Button) view.findViewById(R.id.gd_min_btn);
        btnCBMin = (Button) view.findViewById(R.id.cb_min_btn);

        txtCD = (TextView) view.findViewById(R.id.cd_txt);
        txtCND = (TextView) view.findViewById(R.id.cnd_txt);
        txtEB = (TextView) view.findViewById(R.id.eb_txt);
        txtFB = (TextView) view.findViewById(R.id.fb_txt);
        txtGD = (TextView) view.findViewById(R.id.gd_txt);
        txtCB = (TextView) view.findViewById(R.id.cb_txt);

        btnAct(btnCDAdd, btnCDMin, txtCD, 170);
        btnAct(btnCNDAdd, btnCNDMin, txtCND, 170);
        btnAct(btnEBAdd, btnEBMin, txtEB, 170);
        btnAct(btnFBAdd, btnFBMin, txtFB, 170);
        btnAct(btnGDAdd, btnGDMin, txtGD, 170);
        btnAct(btnCBAdd, btnCBMin, txtCB, 170);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void btnAct(Button btnA, Button btnM, TextView numText, int price) {
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer disVal = Integer.valueOf(numText.getText().toString());
                disVal = disVal + 1;
                numText.setText(String.valueOf(disVal));
                UsersData.totalValue = UsersData.totalValue + price;
            }

        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer disVal = Integer.valueOf(numText.getText().toString());
                if (disVal > 0) {
                    disVal = disVal - 1;
                    numText.setText(String.valueOf(disVal));
                    UsersData.totalValue = UsersData.totalValue - price;
                }
            }
        });
    }
    public static void clearValPastry(){
        txtCD.setText("0");
        txtCND.setText("0");
        txtEB.setText("0");
        txtFB.setText("0");
        txtGD.setText("0");
        txtCB.setText("0");
    }
}