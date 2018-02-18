package com.example.greenhome_v2;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
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

public class Question5 extends AppCompatActivity {
    public Stack<String> qs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        qs = LoadQuestions();
        TextView Text1 = findViewById(R.id.questionText7);
        final TextInputEditText options1 = findViewById(R.id.answerField7);
        TextView Text2 = findViewById(R.id.questionText8);
        final Spinner options2 = findViewById(R.id.answerField8);
        LoadScreen(Text1,options1,qs, Text2, options2);
        final ImageButton button = findViewById(R.id.nextButton5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoadNext(options1, options2);
            }
        });

    }
    private void LoadScreen(TextView text, TextInputEditText options, Stack<String> q, TextView text2, Spinner options2)
    {
        text.setText(q.pop());
        text2.setText(q.pop());
        String items[] = new String[]{"0","1", "2", "3", "4", "5" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        options2.setAdapter((adapter));
    }
    private void LoadNext(TextInputEditText options, Spinner options2)
    {
        writeToFile(options.getText().toString(), this);
        writeToFile(options2.getSelectedItem().toString(), this);
        Intent myIntent = new Intent(Question5.this, Question6.class);
        Question5.this.startActivity(myIntent);
    }
    private Stack<String> LoadQuestions()
    {
        Stack<String> Qs = new Stack<>();
        Qs.push("What car do you have?");
        Qs.push("How many people live in the household");
        Qs.push("On average how long are you're showers?");
        return  Qs;
    }
    private void writeToFile(String data,Context context) {
        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Answers.txt", Context.MODE_PRIVATE));
            outputStreamWriter.append(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
