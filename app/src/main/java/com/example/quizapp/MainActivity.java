package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button ProceedBtn,reviseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProceedBtn = findViewById(R.id.proceedBtn);
        reviseBtn=findViewById(R.id.reviseBtn);
        EditText name = findViewById(R.id.nameInput);
        EditText rollNum = findViewById(R.id.rollNumberInput);
        ProceedBtn.setOnClickListener(v -> {
            String data1 = name.getText().toString();
            String data2 = rollNum.getText().toString();
            Intent nextScreen = new Intent(getApplicationContext(),Questionnaire.class);
            nextScreen.putExtra("Name", data1);
            nextScreen.putExtra("RollNum",data2);
            startActivity(nextScreen);
        });
        reviseBtn.setOnClickListener(v -> {
            String url = "https://learn-quran-kids.com/tajweed/makharij-emission-points/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

    }