package com.example.girich_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class t2_lab3_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // загрузка интерфейса из файла activity_main.xml
        setContentView(R.layout.t2_lab_3_activity2);
    }
}

//    int clicks = 0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.t2_lab_3_activity_main);
//        View plusButtonView = findViewById(R.id.plus_button);
//        View minusButtonView = findViewById(R.id.minus_button);
//        TextView clicksText = findViewById(R.id.clicksText);
//        Button plusButton =
//                plusButtonView.findViewById(R.id.clickBtn);
//        Button minusButton =
//                minusButtonView.findViewById(R.id.clickBtn);
//        plusButton.setText("+");
//        minusButton.setText("-");
//        plusButton.setOnClickListener(v -> {
//            clicks++;
//            clicksText.setText(clicks + " Clicks");
//        });
//        minusButton.setOnClickListener(v -> {
//            clicks--;
//            clicksText.setText(clicks + " Clicks");
//        });


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // загрузка интерфейса из файла activity_main.xml
//        setContentView(R.layout.t2_lab_3_activity);


