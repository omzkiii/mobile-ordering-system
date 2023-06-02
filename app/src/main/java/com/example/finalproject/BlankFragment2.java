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

public class BlankFragment2 extends Fragment {
    Button btnIAMin, btnILMin, btnIMMin, btnICMMin, btnIGTMin, btnIWMin, btnIAAdd, btnILAdd, btnIMAdd, btnICMAdd, btnIGTAdd, btnIWAdd;
    @SuppressLint("StaticFieldLeak")
    public static TextView txtIA, txtIL, txtIM, txtICM, txtIGT, txtIW;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        btnIAAdd = (Button) view.findViewById(R.id.ia_add_btn);
        btnILAdd = (Button) view.findViewById(R.id.il_add_btn);
        btnIMAdd = (Button) view.findViewById(R.id.im_add_btn);
        btnICMAdd = (Button) view.findViewById(R.id.icm_add_btn);
        btnIGTAdd = (Button) view.findViewById(R.id.igt_add_btn);
        btnIWAdd = (Button) view.findViewById(R.id.iw_add_btn);

        btnIAMin = (Button) view.findViewById(R.id.ia_min_btn);
        btnILMin = (Button) view.findViewById(R.id.il_min_btn);
        btnIMMin = (Button) view.findViewById(R.id.im_min_btn);
        btnICMMin = (Button) view.findViewById(R.id.icm_min_btn);
        btnIGTMin = (Button) view.findViewById(R.id.igt_min_btn);
        btnIWMin = (Button) view.findViewById(R.id.iw_min_btn);

        txtIA = (TextView) view.findViewById(R.id.ia_txt);
        txtIL = (TextView) view.findViewById(R.id.il_txt);
        txtIM = (TextView) view.findViewById(R.id.im_txt);
        txtICM = (TextView) view.findViewById(R.id.icm_txt);
        txtIGT = (TextView) view.findViewById(R.id.igt_txt);
        txtIW = (TextView) view.findViewById(R.id.iw_txt);

        btnAct(btnIAAdd, btnIAMin, txtIA, 170);
        btnAct(btnILAdd, btnILMin, txtIL, 170);
        btnAct(btnIMAdd, btnIMMin, txtIM, 170);
        btnAct(btnICMAdd, btnICMMin, txtICM, 170);
        btnAct(btnIGTAdd, btnIGTMin, txtIGT, 170);
        btnAct(btnIWAdd, btnIWMin, txtIW, 170);
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
    public static void clearValIced(){
        txtIA.setText("0");
        txtIL.setText("0");
        txtIM.setText("0");
        txtICM.setText("0");
        txtIGT.setText("0");
        txtIW.setText("0");
    }
}