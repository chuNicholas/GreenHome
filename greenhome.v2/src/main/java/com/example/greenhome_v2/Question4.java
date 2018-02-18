package com.example.greenhome_v2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Question4 extends AppCompatActivity {
    public Stack<String> qs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        qs = LoadQuestions();
        TextView Text1 = findViewById(R.id.questionText5);
        final Spinner options1 = findViewById(R.id.answerField5);
        TextView Text2 = findViewById(R.id.questionText6);
        final CheckBox options2 = findViewById(R.id.answerField6);
        LoadScreen(Text1,options1,qs, Text2);
        final ImageButton button = findViewById(R.id.nextButton4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoadNext(options1, options2);
            }
        });

    }
    private void LoadScreen(TextView text, Spinner options, Stack<String> q, TextView text2)
    {
        text.setText(q.pop());
        text2.setText(q.pop());
        String items[] = new String[]{"0","1", "2", "3", "4", "5" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        options.setAdapter((adapter));
    }
    private void LoadNext(Spinner options, CheckBox options2)
    {
        //writeToFile(options.getSelectedItem().toString(), this);
        MainActivity.dish_Washer_Uses = Integer.parseInt(options.getSelectedItem().toString());

        if(options2.isChecked())
            MainActivity.is_ES = true;
        else
            MainActivity.is_ES = false;
        Intent myIntent = new Intent(Question4.this, Question5.class);
        Question4.this.startActivity(myIntent);
    }
    private Stack<String> LoadQuestions()
    {
        Stack<String> Qs = new Stack<>();
        Qs.push("How many people live in the household");
        Qs.push("On average how long are your showers in minutes?");
        Qs.push("How many litres of Water do you use (Per Month");
        Qs.push("What car do you have?");
        Qs.push("Is it an Energy Saver?");
        Qs.push("How many times do you use the dishwasher per week?");
        return  Qs;
    }
    /*
    private void writeToFile(String data,Context context) {
        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Answers.txt", Context.MODE_PRIVATE));
            outputStreamWriter.append(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }*/
}
