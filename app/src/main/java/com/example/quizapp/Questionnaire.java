package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Questionare extends AppCompatActivity {
    TextView questionBox;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3,r4;
    String[] questions = {
            "Which letters of \"Halqiyah\" originate sound from Middle of Throat?",
            "Pair of letters included in \"Halqiyah\"?",
            "Word ق from \"Lahatiyah\" generates sound from which part of tongue?",
            "Pair of letters \" ض ج ش ی \" are part of which \"makhārij al-ḥurūf\"?",
            "Rounded tip of the tongue touching the base of the frontal 6 teeth can produce sound of which letter?",
            "Tip of the tongue comes between the front top and bottom teeth produce sound of which pair?",
            "How \"Ghunna\" sounds are produced?",
            "How many emission points (makhārij al-ḥurūf) are located in human skeleton/face?",
            "Pair of letters \"ت د ط \" are part of which \"makhārij al-ḥurūf\"?",
            "What will happen if you block/press your nose completely?",
    };
    String[] anwsers ={
            "ن",
            "Shajariyah-Haafiyah",
            "Base of tongue near Uvula",
            "غ خ",
            "ع ح",
            "ص ز س",
            "When noise vibrates while emitting letters",
            "17",
            "Nit-eeyah",
            "None of these",
    };
    String[] options ={"غ خ","ع ح","أ ہ","ت د ط",
            "ن","ج ش ی","ت د ط","غ خ",
            "Base of tongue near Uvula","Portion of tongue near its base touching roof of mouth","Bottom of the tongue","Sides of the tongue",
            "Lahatiyah","Halqiyah", "Shajariyah-Haafiyah", "Ghunna",
            "ف","ر ","ن ","ل ",
            "م ن","ص ز س","ظ  ذ  ث","ت د ط",
            "When inner part of the both lips touch each other", "When Outer part of both lips touch each other" , "When noise vibrates while emitting letters", "None of these",
            "16", "17", "18", "19",
            "Lahatiyah", "Nit-eeyah", "Shajariyah-Haafiyah", "Halqiyah",
            "Shrill sound", "No Sound", "Grave sound" , "None of these"
    };
    public static int correct=0,wrong=0;
    TextView name_msg,roll_msg,count;
    static int counter=0;
    Button submitBtn,quitBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        name_msg = findViewById(R.id.name_display);
        roll_msg = findViewById(R.id.roll_display);
        count=findViewById(R.id.counterView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Name");
        name_msg.setText(str);
        String str2 = intent.getStringExtra("RollNum");
        roll_msg.setText(str2);
        questionBox=findViewById(R.id.questionBox);
        submitBtn=findViewById(R.id.submitBtn);
        quitBtn=findViewById(R.id.quitBtn);
        questionBox.setText(questions[0]);
        radioGroup=findViewById(R.id.radioGroup);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
        r4=findViewById(R.id.radioButton4);
        r1.setText(options[0]);
        r2.setText(options[1]);
        r3.setText(options[2]);
        r4.setText(options[3]);

        submitBtn.setOnClickListener(v -> {

            if(radioGroup.getCheckedRadioButtonId()==-1){
                Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton userAnwser = findViewById(radioGroup.getCheckedRadioButtonId());
            String anwserText = userAnwser.getText().toString();

            if(anwserText.equals(anwsers[counter])){
                correct++;
            }else {
                wrong++;
            }
            counter++;

            if(counter<questions.length)
            {
                questionBox.setText(questions[counter]);
                r1.setText(options[counter*4]);
                r2.setText(options[counter*4 +1]);
                r3.setText(options[counter*4 +2]);
                r4.setText(options[counter*4 +3]);
                count.setText(counter+ "/10");
            }
            else
            {
                Intent in = new Intent(getApplicationContext(),Result.class);
                startActivity(in);
            }
            if(counter==10){
                String data1 = name_msg.getText().toString();
                String data2 = roll_msg.getText().toString();
                String data3 = Integer.toString(counter);
                String data4 = Integer.toString(correct);
                String data5 = Integer.toString(wrong);
                Intent intent1 =new Intent(getApplicationContext(),Result.class);
                intent1.putExtra("Name#",data1);
                intent1.putExtra("Roll#",data2);
                intent1.putExtra("Counter++",data3);
                intent1.putExtra("Correct++",data4);
                intent1.putExtra("Wrong++",data5);
                startActivity(intent1);}
            radioGroup.clearCheck();
        });

        quitBtn.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),MainActivity.class);
            counter=0;
            wrong=0;
            correct=0;
            startActivity(intent1);
        });
    }
}