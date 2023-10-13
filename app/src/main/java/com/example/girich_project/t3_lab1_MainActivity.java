package com.example.girich_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class t3_lab1_MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t3_lab_1_activity);
    }

    public void onClick(View view) {
        Snackbar snackbar = Snackbar.make(view, "Hello Android",
                Snackbar.LENGTH_LONG);
        snackbar.setAction("Next...", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Next clicked!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        snackbar.show();
        snackbar.setTextColor(0XFF81C784);
        snackbar.setBackgroundTint(0XFF555555);
        snackbar.setActionTextColor(0XFF0277BD);
    }
}


//    public void onClick(View view){
//        LayoutInflater inflater = getLayoutInflater();
//        View layout = inflater.inflate(R.layout.t3_lab_1_custom_toast,
//                findViewById(R.id.toast_layout));
//        TextView text = layout.findViewById(R.id.text);
//        text.setText("Hello Android!");
//        Toast toast = new Toast(getApplicationContext());
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setView(layout);
//        toast.show();
//    }




