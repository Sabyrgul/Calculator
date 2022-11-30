package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String result=getIntent().getStringExtra("keyResult");
        TextView textView=findViewById(R.id.text_view2);
        textView.setText(result);
        findViewById(R.id.close_button).setOnClickListener(view -> {
            finishAffinity();
                }

        );
    }
}