package com.example.girich_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class t4_lab3_MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t4_lab_3_activity_main2);
    }

    public void onClick(View v) {
        EditText nameText = findViewById(R.id.name);
        EditText companyText = findViewById(R.id.company);
        EditText ageText = findViewById(R.id.age);
        String name = nameText.getText().toString();
        String company = companyText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());
        t4_lab3_User user = new t4_lab3_User(name, company, age);
        Intent intent = new Intent(this, t4_lab_3_SecondActivity2.class);
        intent.putExtra(t4_lab3_User.class.getSimpleName(), user);
        startActivity(intent);
    }
}

