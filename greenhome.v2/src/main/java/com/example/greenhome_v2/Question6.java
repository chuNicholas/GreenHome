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

public class Question6 extends AppCompatActivity {
    public Stack<String> qs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        qs = LoadQuestions();
        TextView Text = findViewById(R.id.questionText9);
        final Spinner options = findViewById(R.id.answerField9);
        LoadScreen(Text,options,qs);
        final ImageButton button = findViewById(R.id.nextButton6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoadNext(options);
            }
        });
    }
    private void LoadScreen(TextView text, Spinner options, Stack<String> q)
    {
        text.setText(q.pop());
        String items[] = new String[]{"Sedan","SUV", "Electric", "Truck" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        options.setAdapter((adapter));
    }
    private void LoadNext(Spinner options)
    {
        writeToFile(options.getSelectedItem().toString(), this);
        Intent myIntent = new Intent(Question6.this, MainActivity.class);
        myIntent.putExtra("arg", false);
        Question6.this.startActivity(myIntent);
    }
    private Stack<String> LoadQuestions()
    {
        Stack<String> Qs = new Stack<>();
        Qs.push("What car do you have?");

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
