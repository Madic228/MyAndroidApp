package com.example.girich_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class t4_lab3_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t4_lab_3_activity_main);
    }
    public void onClick(View v) {
        EditText nameText = findViewById(R.id.name);
        EditText companyText = findViewById(R.id.company);
        EditText ageText = findViewById(R.id.age);
        String name = nameText.getText().toString();
        String company = companyText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());
        Intent intent = new Intent(this, t4_lab_3_SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("company", company);
        intent.putExtra("age", age);
        startActivity(intent);
    }
}

