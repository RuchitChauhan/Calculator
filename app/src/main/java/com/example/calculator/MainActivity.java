package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, divide, multiply, plus, minus, ac, delete, dot, bracket, percentage, equal;
    TextView txt;
    String expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression == null) {
                    expression = "";
                } else {
                    expression = expression + "-";
                }
                txt.setText(expression);

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression == null) {
                    expression = "";
                } else {
                    expression = expression + "/";
                }
                txt.setText(expression);

            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = "";
                txt.setText(expression);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!expression.isEmpty()) {
                    expression = expression.substring(0, expression.length() - 1);
                    txt.setText(expression);
                }
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression != null && !expression.isEmpty()) {
                    try {
                        Expression exp = new ExpressionBuilder(expression).build();
                        double result = exp.evaluate();
                        txt.setText(String.valueOf(result));
                        expression = String.valueOf(result); // So user can continue from result
                    } catch (Exception e) {
                        txt.setText("Error");
                        expression = "";
                    }
                }
            }
        });


    }

    private void init() {

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        ac = findViewById(R.id.ac);
        delete = findViewById(R.id.delete);
        dot = findViewById(R.id.dot);
        percentage = findViewById(R.id.percentage);
        bracket = findViewById(R.id.bracket);
        equal = findViewById(R.id.equal);
        txt = findViewById(R.id.result);
    }


    public void check(View v) {

        Button current = (Button) v;
        if (expression == null) {
            expression = current.getText().toString();
        } else {
            expression = expression + current.getText().toString();
        }
        txt.setText(expression);
    }

}
