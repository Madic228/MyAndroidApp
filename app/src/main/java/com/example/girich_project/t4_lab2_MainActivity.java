package com.example.girich_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class t4_lab2_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t4_lab_2_activity_main);
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, t4_lab_2_SecondActivity.class);
        startActivity(intent);
    }
}

