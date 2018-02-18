package com.example.greenhome_v2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Question2 extends AppCompatActivity {

    public Stack<String> qs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        qs = LoadQuestions();
        TextView Text = findViewById(R.id.questionText2);
        final Spinner options = findViewById(R.id.answerField2);
        LoadScreen(Text,options,qs);
        final ImageButton button = findViewById(R.id.nextButton2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoadNext(options);
            }
        });
    }
    private void LoadScreen(TextView text, Spinner options, Stack<String> q)
    {
        text.setText(q.pop());
        String items[] = new String[]{"incandescent","LED", "Other" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        options.setAdapter((adapter));
    }
    private void LoadNext(Spinner options)
    {
        //writeToFile(options.getSelectedItem().toString(), this);
        MainActivity.type_Of_Bulb = options.getSelectedItem().toString();


                Intent myIntent = new Intent(Question2.this, Question3.class);
        Question2.this.startActivity(myIntent);
    }
    private Stack<String> LoadQuestions()
    {
        Stack<String> Qs = new Stack<>();
        Qs.push("How many people live in the household");
        Qs.push("On average how long are you're showers?");
        Qs.push("How many litres of Water do you use (Per Month");
        Qs.push("What car do you have?");
        Qs.push("Is it HE?");
        Qs.push("How many times do you use the dishwasher per week?");
        Qs.push("Is it HE?");
        Qs.push("How many times do you use the Washing Machine per week?");
        Qs.push("What kind of lightbulbs are in the House");
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
