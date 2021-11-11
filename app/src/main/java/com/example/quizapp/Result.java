package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView _name,_rollNum;
    Button quitButton, shareButton;
    TextView scoreField,correctField,wrongField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        _name=findViewById(R.id.nameText);
        _rollNum=findViewById(R.id.rollText);
        quitButton=findViewById(R.id.quitButton);
        shareButton=findViewById(R.id.shareBtn);
        scoreField=findViewById(R.id.score);
        wrongField=findViewById(R.id.wrongInput);
        correctField=findViewById(R.id.correctInput);

        Intent GET = getIntent();
        String text1 = GET.getStringExtra("Name#");
        _name.setText(text1);
        String text2 = GET.getStringExtra("Roll#");
        _rollNum.setText(text2);
        String text4 = GET.getStringExtra("Correct++");
        correctField.setText(text4);
        scoreField.setText(text4+'0');
        String text5 = GET.getStringExtra("Wrong++");
        wrongField.setText(text5);

        Questionnaire.counter=0;
        Questionnaire.correct=0;
        Questionnaire.wrong=0;

        quitButton.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

        shareButton.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Total Score = ");
            sendIntent.putExtra(Intent.EXTRA_TEXT,correctField.getText().toString());
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });
    }
}