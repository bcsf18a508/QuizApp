package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Starter extends AppCompatActivity {
    Button repo,app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        repo=findViewById(R.id.RepoBtn);
        app=findViewById(R.id.movetoAPP);

        repo.setOnClickListener(v -> {
            String url = "https://github.com/SaadNiaziDev";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        app.setOnClickListener(v ->{
            Intent nextScreen = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(nextScreen);
        });
    }
}