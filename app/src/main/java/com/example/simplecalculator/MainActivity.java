package com.example.simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etFirstNumber, etSecondNumber;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView tvResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> calculate('+'));

        btnSubtract.setOnClickListener(v -> calculate('-'));

        btnMultiply.setOnClickListener(v -> calculate('*'));

        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    @SuppressLint("SetTextI18n")
    private void calculate(char operator) {
        String num1 = etFirstNumber.getText().toString();
        String num2 = etSecondNumber.getText().toString();

        if (!num1.isEmpty() && !num2.isEmpty()) {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double result = 0;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        tvResult.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }
            tvResult.setText("Result: " + result);
        } else {
            tvResult.setText("Please enter both numbers");
        }
    }
}
