package com.example.girich_project;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class t6_lab_2_MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6_lab_2_activity_main4);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = findViewById(R.id.selectedMenuItem);

        if (id == R.id.action_settings) {
            headerView.setText("Настройки");
            return true;
        } else if (id == R.id.open_settings) {
            headerView.setText("Открыть");
            return true;
        } else if (id == R.id.save_settings) {
            headerView.setText("Сохранить");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


