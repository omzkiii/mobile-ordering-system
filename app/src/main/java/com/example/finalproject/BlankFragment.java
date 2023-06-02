package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BlankFragment extends Fragment {
    Button btnCMin, btnDMMin, btnGTMin, btnJCMin, btnMMin, btnSTMin, btnCAdd, btnDMAdd, btnGTAdd, btnJCAdd, btnMAdd, btnSTAdd;
    @SuppressLint("StaticFieldLeak")
    public static TextView txtC, txtDM, txtGT, txtJC, txtM, txtST;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        btnCAdd = (Button) view.findViewById(R.id.c_add_btn);
        btnDMAdd = (Button) view.findViewById(R.id.dm_add_btn);
        btnGTAdd = (Button) view.findViewById(R.id.gt_add_btn);
        btnJCAdd = (Button) view.findViewById(R.id.jc_add_btn);
        btnMAdd = (Button) view.findViewById(R.id.m_add_btn);
        btnSTAdd = (Button) view.findViewById(R.id.st_add_btn);

        btnCMin = (Button) view.findViewById(R.id.c_min_btn);
        btnDMMin = (Button) view.findViewById(R.id.dm_min_btn);
        btnGTMin = (Button) view.findViewById(R.id.gt_min_btn);
        btnJCMin = (Button) view.findViewById(R.id.jc_min_btn);
        btnMMin = (Button) view.findViewById(R.id.m_min_btn);
        btnSTMin = (Button) view.findViewById(R.id.st_min_btn);

        txtC = (TextView) view.findViewById(R.id.c_txt);
        txtDM = (TextView) view.findViewById(R.id.dm_txt);
        txtGT = (TextView) view.findViewById(R.id.gt_txt);
        txtJC = (TextView) view.findViewById(R.id.jc_txt);
        txtM = (TextView) view.findViewById(R.id.m_txt);
        txtST = (TextView) view.findViewById(R.id.st_txt);

        btnAct(btnCAdd, btnCMin, txtC, 170);
        btnAct(btnDMAdd, btnDMMin, txtDM, 180);
        btnAct(btnGTAdd, btnGTMin, txtGT, 190);
        btnAct(btnJCAdd, btnJCMin, txtJC, 180);
        btnAct(btnMAdd, btnMMin, txtM, 170);
        btnAct(btnSTAdd, btnSTMin, txtST, 190);
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
    public static void clearValFrappe(){
        txtC.setText("0");
        txtDM.setText("0");
        txtGT.setText("0");
        txtJC.setText("0");
        txtM.setText("0");
        txtST.setText("0");
    }
}