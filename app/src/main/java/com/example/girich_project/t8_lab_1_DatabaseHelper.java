package com.example.girich_project;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class t8_lab_1_DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_PATH; // полный путь к базе данных
    private static String DB_NAME = "cityinfo.db";
    private static final int SCHEMA = 1;
    // версия базы данных
    static final String TABLE = "users";
    // название таблицы в бд
    // названия столбцов
    static final String COLUMN_ID = "_id";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_YEAR = "year";
    private Context myContext;
    t8_lab_1_DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + DB_NAME;
    }
    @Override
    public void onCreate(SQLiteDatabase db) { }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) { }
    void create_db(){
        File file = new File(DB_PATH);
        if (!file.exists()) {
            //получаем локальную бд как поток
            try(InputStream myInput =
                        myContext.getAssets().open(DB_NAME);
                // Открываем пустую бд
                OutputStream myOutput = new
                        FileOutputStream(DB_PATH)) {
                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch(IOException ex){
                Log.d("t8_lab_1_DatabaseHelper", ex.getMessage());
            }
        }
    }
    public SQLiteDatabase open()throws SQLException {
        return SQLiteDatabase.openDatabase(DB_PATH, null,
                SQLiteDatabase.OPEN_READWRITE);
    }
}




















//    private static final String DATABASE_NAME =
//            "userstore.db"; // название бд
//    private static final int SCHEMA = 1; // версия базы данных
//    static final String TABLE = "users"; // название таблицы в бд
//    // названия столбцов
//    public static final String COLUMN_ID = "_id";
//    public static final String COLUMN_NAME = "name";
//    public static final String COLUMN_YEAR = "year";
//    public t8_lab_1_DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, SCHEMA);
//    }
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE users (" + COLUMN_ID
//                + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COLUMN_NAME
//                + " TEXT, " + COLUMN_YEAR + " INTEGER);");
//        // добавление начальных данных
//        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
//                        + ", " + COLUMN_YEAR + ") VALUES ('Том Смит', 1981);");
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion,
//                          int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
//        onCreate(db);
//    }
//}
