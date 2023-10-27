package com.example.girich_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class t4_lab_3_SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(26);
        textView.setPadding(16, 16, 16, 16);
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            String name = arguments.get("name").toString();
            String company = arguments.getString("company");
            int age = arguments.getInt("age");
            textView.setText("Name: " + name + "\nCompany: " +
                    company +
                    "\nAge: " + age);
        }
        setContentView(textView);
    }
}
