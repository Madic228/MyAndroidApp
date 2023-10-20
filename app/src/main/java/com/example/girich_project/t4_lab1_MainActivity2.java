package com.example.girich_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;


public class t4_lab1_MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t4_lab_1_activity_main2);
        TextView timeTextView = findViewById(R.id.timeTextView);
        TimePicker timePicker = findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener
                (new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker view, int
                            hourOfDay, int minute)
                    {
                        timeTextView.setText("Время: " + hourOfDay + ":" + minute);
                        // или так
                        // timeTextView.setText("Время: " + view.getHour() + ":" +
                        //view.getMinute());
                    }
                });
    }
}

