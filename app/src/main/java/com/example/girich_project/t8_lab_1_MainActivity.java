package com.example.girich_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class t8_lab_1_MainActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    t8_lab_1_DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t8_lab_1_activity_main);
        header = findViewById(R.id.header);
        userList = findViewById(R.id.list);
        databaseHelper = new t8_lab_1_DatabaseHelper(getApplicationContext());
    }
    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = databaseHelper.getReadableDatabase();
        //получаем данные из бд в виде курсора
        userCursor = db.rawQuery("select * from "+
                t8_lab_1_DatabaseHelper.TABLE, null);
        // определяем, какие столбцы из курсора будут выводиться
        String[] headers = {t8_lab_1_DatabaseHelper.COLUMN_NAME, t8_lab_1_DatabaseHelper.COLUMN_YEAR};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1,
                android.R.id.text2}, 0);
        header.setText("Найдено элементов: " +
                userCursor.getCount());
        userList.setAdapter(userAdapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}
