package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String exp1 = "", exp2 = "";
    String expression = "";
    int first = 1;
    int opr = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText result = findViewById(R.id.result);
        Button one = findViewById(R.id.button1);
        Button two = findViewById(R.id.button2);
        Button three = findViewById(R.id.button3);
        Button four = findViewById(R.id.button4);
        Button five = findViewById(R.id.button5);
        Button six = findViewById(R.id.button6);
        Button seven = findViewById(R.id.button7);
        Button eight = findViewById(R.id.button8);
        Button nine = findViewById(R.id.button9);
        Button zero = findViewById(R.id.button0);
        Button add = findViewById(R.id.buttonadd);
        Button sub = findViewById(R.id.buttonsub);
        Button mul = findViewById(R.id.buttonmul);
        Button div = findViewById(R.id.buttondiv);
        Button equal = findViewById(R.id.buttonequal);
        Button ac = findViewById(R.id.buttonac);



        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp1 = "";
                exp2 = "";
                expression = "";
                first = 1;
                result.setText(expression);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "1";
                }
                else{
                    exp2 = exp2 + "1";
                    result.setText(exp2);
                }
                expression = expression + "1";
                result.setText(expression);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "2";
                }
                else{
                    exp2 = exp2 + "2";
                    result.setText(exp2);
                }
                expression = expression + "2";
                Log.d("notice: ", expression);
                result.setText(expression);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "3";
                }
                else{
                    exp2 = exp2 + "3";
                    result.setText(exp2);
                }
                expression = expression + "3";
                result.setText(expression);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "4";
                }
                else{
                    exp2 = exp2 + "4";
                    result.setText(exp2);
                }
                expression = expression + "4";
                result.setText(expression);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "5";
                }
                else{
                    exp2 = exp2 + "5";
                    result.setText(exp2);
                }
                expression = expression + "5";
                result.setText(expression);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "6";
                }
                else{
                    exp2 = exp2 + "6";
                    result.setText(exp2);
                }
                expression = expression + "6";
                result.setText(expression);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "7";
                }
                else{
                    exp2 = exp2 + "7";
                    result.setText(exp2);
                }
                expression = expression + "7";
                result.setText(expression);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "8";
                }
                else{
                    exp2 = exp2 + "8";
                    result.setText(exp2);
                }
                expression = expression + "8";
                result.setText(expression);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "9";
                }
                else{
                    exp2 = exp2 + "9";
                    result.setText(exp2);
                }
                expression = expression + "9";
                result.setText(expression);
            }
        });


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first==1){
                    exp1 = exp1 + "0";
                }
                else{
                    exp2 = exp2 + "0";
                    result.setText(exp2);
                }
                expression = expression + "0";
                result.setText(expression);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first == 1) {
                    first = 2;
                    opr = 1;
                }
                expression = expression + "+";
                result.setText(expression);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first == 1) {
                    first = 2;
                    opr = 2;
                }
                expression = expression + "-";
                result.setText(expression);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first == 1) {
                    first = 2;
                    opr = 3;
                }
                expression = expression + "x";
                result.setText(expression);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(first == 1) {
                    first = 2;
                    opr = 4;
                }
                expression = expression + "/";
                result.setText(expression);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(exp1);
                int num2 = Integer.parseInt(exp2);
                int res;

                if(opr==1){
                    res = num1+num2;
                }
                else if(opr==2){
                    res = num1-num2;
                }
                else if(opr==3){
                    res = num1*num2;
                }
                else{
                    res = num1/num2;
                }

                String finalResult = Integer.toString(res);

                result.setText(finalResult);
                expression = finalResult;
                exp1 = finalResult;
                first = 1;
                exp2 = "";
            }
        });



    }
}