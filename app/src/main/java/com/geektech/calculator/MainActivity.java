package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstNum, secondNum;
    private String operation;
    private Boolean isOperationClick;
    private Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_view);
    }
    public TextView checkZero(String symbol){
        if(textView.getText().toString().equals("0")||isOperationClick){
            textView.setText(symbol);
        }else textView.append(symbol);
        return textView;
    }
   public void onSymbolClick(View view) {

        switch(view.getId()){
            case R.id.btn_1:
                checkZero("1");
                break;
            case R.id.btn_2:
                checkZero("2");
                break;
            case R.id.btn_3:
                checkZero("3");
                break;
            case R.id.btn_4:
                checkZero("4");
                break;
            case R.id.btn_5:
                checkZero("5");
                break;
            case R.id.btn_6:
                checkZero("6");
                break;
            case R.id.btn_7:
                checkZero("7");
                break;
            case R.id.btn_8:
                checkZero("8");
                break;
            case R.id.btn_9:
                checkZero("9");
                break;
            case R.id.btn_0:
                checkZero("0");
                break;
            case R.id.btn_clear:
                textView.setText("0");
                break;
        }
        isOperationClick=false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case (R.id.btn_plus):
                firstNum= Integer.valueOf(textView.getText().toString());
             operation="sum";
                break;
            case(R.id.btn_minus):
                firstNum= Integer.valueOf(textView.getText().toString());
               operation="minus";
               break;
            case(R.id.btn_multiplication):
                firstNum= Integer.valueOf(textView.getText().toString());
                operation="multiply";
                break;
            case(R.id.btn_division):
                firstNum= Integer.valueOf(textView.getText().toString());
                operation="divide";
                break;
            case(R.id.btn_equal):
                secondNum= Integer.valueOf(textView.getText().toString());
                switch (operation){
                    case "sum":
                        result=firstNum+secondNum;
                        break;
                    case "minus":
                        result=firstNum-secondNum;
                        break;
                    case "multiply":
                        result=firstNum*secondNum;
                        break;
                    case "divide":
                        result=firstNum/secondNum;
                        break;
                }
                textView.setText(result.toString());
                break;
        }
        isOperationClick=true;
    }
}