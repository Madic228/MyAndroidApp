package com.example.girich_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class t2_lab1_MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
        // установка layout_gravity
        layoutParams.gravity = Gravity.CENTER;
        // первое текстовое поле
        TextView textView1 = new TextView(this);
        textView1.setText("Hello");
        textView1.setTextSize(30);
        linearLayout.addView(textView1, layoutParams);
        setContentView(linearLayout);
    }
}


//public class t2_lab1_MainActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        // первое текстовое поле
//        TextView textView1 = new TextView(this);
//        textView1.setText("Hello");
//        textView1.setTextSize(30);
//        // textView1 имеет вес 3
//        linearLayout.addView(textView1, new LinearLayout.LayoutParams
//                (LinearLayout.LayoutParams.MATCH_PARENT, 0, 3));
//        // второе текстовое поле
//        TextView textView2 = new TextView(this);
//        textView2.setText("Android");
//        textView2.setBackgroundColor(0xFFBDBDBD);
//        textView2.setTextSize(30);
//        // textView2 имеет вес 2
//        linearLayout.addView(textView2, new LinearLayout.LayoutParams
//                (LinearLayout.LayoutParams.MATCH_PARENT, 0, 2));
//        setContentView(linearLayout);
//    }
//}



// Программное создание LinearLayout
// public class t2_lab1_MainActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         //setContentView(R.layout.activity_main);
//         LinearLayout linearLayout = new LinearLayout(this);
//         // горизонтальная ориентация
//         linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//
//         TextView textView = new TextView(this);
//         textView.setText("Hello");
//         textView.setTextSize(30);
//         // создаем параметры позиционирования для элемента
//         LinearLayout.LayoutParams layoutParams = new
//                LinearLayout.LayoutParams
//         (LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//         // устанавливаем отступы
//         layoutParams.setMargins(100, 100, 0, 0);
//         textView.setLayoutParams(layoutParams);
//         // добавляем элемент в LinearLayout
//         linearLayout.addView(textView);
//
//         setContentView(linearLayout);
//         }
// }