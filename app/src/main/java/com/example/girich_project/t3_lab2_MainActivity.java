package com.example.girich_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class t3_lab2_MainActivity extends AppCompatActivity {
    // Объявление переменных
    TextView resultField; // Поле для отображения результата
    EditText numberField; // Поля для ввода чисел
    TextView operationField; // Поля для отображения операции
    Double operand = null; //  Переменная для хранения операнда
    String lastOperation = "="; // Переменная для сохранения последней операции

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t3_lab_2_activity_main);

        // Привязка переменных к элементам интерфейса
        resultField = findViewById(R.id.resultField);
        numberField = findViewById(R.id.numberField);
        operationField = findViewById(R.id.operationField);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Сохранение состояния активности при её уничтожении (например, при повороте экрана)
        outState.putString("OPERATION", lastOperation);
        if (operand != null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }

    // Восстановление сохраненного состояния при создании активности
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand = savedInstanceState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        operationField.setText(lastOperation);
    }

    //  Обработчик события клика на кнопку с числом
    public void onNumberClick(View view) {
        Button button = (Button) view;
        numberField.append(button.getText());
        if (lastOperation.equals("=") && operand != null) {
            operand = null;
        }
    }

    // Обработчик события клика на кнопку с операцией (+, -, *, /)
    public void onOperationClick(View view) {
        Button button = (Button) view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();
        if (number.length() > 0) {
            number = number.replace(',', '.');
            try {
                performOperation(Double.valueOf(number), op);
            } catch (NumberFormatException ex) {
                numberField.setText("");
            }
        }
        lastOperation = op;
        operationField.setText(lastOperation);
    }

    // Обработчик события клика на кнопку "Очистить" (C)
    public void onClearClick(View view) {
        numberField.setText("");
        resultField.setText("0");
        operationField.setText("");
        operand = null;
        lastOperation = "=";
    }

    // Обработчик события клика на кнопку "Равно" (=)
    public void onEqualsClick(View view) {
        String number = numberField.getText().toString();
        if (number.length() > 0) {
            number = number.replace(',', '.');
            try {
                performOperation(Double.valueOf(number), lastOperation);
            } catch (NumberFormatException ex) {
                numberField.setText("");
            }
        }   
        lastOperation = "=";
        operationField.setText(lastOperation);
    }

    // Метод для выполнения математических операций
    private void performOperation(Double number, String operation) {
        if (operand == null) {
            operand = number;
        } else {
            if (lastOperation.equals("=")) {
                lastOperation = operation;
            }
            switch (lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    if (number == 0) {
                        operand = 0.0;
                    } else {
                        operand /= number;
                    }
                    break;
                case "*":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
            }
        }
        resultField.setText(operand.toString().replace('.', ','));
        numberField.setText("");
    }
}
