package com.example.girich_project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class t8_lab_1_UserActivity extends AppCompatActivity {
    EditText nameBox;
    EditText yearBox;
    Button delButton;
    Button saveButton;
    t8_lab_1_DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    long userId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t8_lab_1_activity_user);
        nameBox = findViewById(R.id.name);
        yearBox = findViewById(R.id.year);
        delButton = findViewById(R.id.deleteButton);
        saveButton = findViewById(R.id.saveButton);
        sqlHelper = new t8_lab_1_DatabaseHelper(this);
        db = sqlHelper.open();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("id");
        }
        // если 0, то добавление
        if (userId > 0) {
            // получаем элемент по id из бд
            userCursor = db.rawQuery("select * from " +
                            t8_lab_1_DatabaseHelper.TABLE + " where " +
                            t8_lab_1_DatabaseHelper.COLUMN_ID + "=?",
                    new String[]{String.valueOf(userId)});
            userCursor.moveToFirst();
            nameBox.setText(userCursor.getString(1));
            yearBox.setText(String.valueOf(userCursor.getInt(2)));
            userCursor.close();
        } else {
            // скрываем кнопку удаления
            delButton.setVisibility(View.GONE);
        }
    }
    public void save(View view){
        ContentValues cv = new ContentValues();
        cv.put(t8_lab_1_DatabaseHelper.COLUMN_NAME,
                nameBox.getText().toString());
        cv.put(t8_lab_1_DatabaseHelper.COLUMN_YEAR,
                Integer.parseInt(yearBox.getText().toString()));
        if (userId > 0) {
            db.update(t8_lab_1_DatabaseHelper.TABLE, cv,
                    t8_lab_1_DatabaseHelper.COLUMN_ID + "=" + userId, null);
        } else {
            db.insert(t8_lab_1_DatabaseHelper.TABLE, null, cv);
        }
        goHome();
    }
    public void delete(View view){
        db.delete(t8_lab_1_DatabaseHelper.TABLE, "_id = ?",
                new String[]{String.valueOf(userId)});
        goHome();
    }
    private void goHome(){
        // закрываем подключение
        db.close();
        // переход к главной activity
        Intent intent = new Intent(this, t8_lab_1_MainActivity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
