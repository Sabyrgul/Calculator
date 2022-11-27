package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double firstNum, secondNum;
    private String operation;
    private Boolean isOperationClick;
    private Double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_view);
    }
    public void checkObject(Double number){
        if(number-number.intValue()==0)
        {
            Integer resultInt=number.intValue();
            textView.setText(resultInt.toString());
        }
        else textView.setText(number.toString());
        operation="";
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
            case R.id.btn_dot:
                textView.append(".");
                break;
            case R.id.btn_clear:
                textView.setText("0");
                break;
        }
        isOperationClick=false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case(R.id.btn_plus_minus):
                firstNum= Double.valueOf(textView.getText().toString());
                if(firstNum>0){
                    firstNum=0-firstNum;
                }
                else
                    firstNum=-firstNum;
                checkObject(firstNum);
                break;
            case (R.id.btn_plus):
                firstNum= Double.valueOf(textView.getText().toString());
             operation="sum";
                break;
            case(R.id.btn_minus):
                firstNum= Double.valueOf(textView.getText().toString());
               operation="minus";
               break;
            case(R.id.btn_multiplication):
                firstNum= Double.valueOf(textView.getText().toString());
                operation="multiply";
                break;
            case(R.id.btn_division):
                firstNum= Double.valueOf(textView.getText().toString());
                operation="divide";
                break;
            case (R.id.btn_percentage):
                secondNum= Double.valueOf(textView.getText().toString());
                 switch (operation){
                    case "sum":
                        result=firstNum*secondNum/100+firstNum;
                        break;
                    case "minus":
                        result=firstNum-firstNum*secondNum/100;
                        break;
                    case "multiply":
                        result=firstNum*secondNum/100;
                        break;
                    case "divide":
                        result=(firstNum/secondNum)*100;
                        break;
                     case "":
                         result=0.0;
                }
                checkObject(result);
                break;
            case(R.id.btn_equal):
                secondNum= Double.valueOf(textView.getText().toString());
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
                checkObject(result);
                break;
        }
        isOperationClick=true;
    }
}