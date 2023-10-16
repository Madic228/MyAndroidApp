package com.example.girich_project;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class t3_lab3_MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t3_lab_3_radiobutton);

        // Получаем объект RadioGroup
        RadioGroup radGrp = findViewById(R.id.radios);

        // Обработка переключения состояния переключателя
        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                TextView selection = findViewById(R.id.selection);
                RadioButton javaRadioButton = findViewById(R.id.java);
                RadioButton kotlinRadioButton = findViewById(R.id.kotlin);

                if (id == javaRadioButton.getId()) {
                    selection.setText("Выбрана Java");
                } else if (id == kotlinRadioButton.getId()) {
                    selection.setText("Выбран Kotlin");
                }
            }
        });
    }
}
