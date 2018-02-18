package com.example.greenhome_v2;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        TextView Text = findViewById(R.id.questionText);
        ImageView banner = findViewById(R.id.BannerType);
        final Stack<String> Questions = LoadQuestions();
        LoadScreen(Text, banner, Questions);
        final ImageButton button = findViewById(R.id.nextButton1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoadNext(Questions);
            }
        });
    }
    private Stack<String> LoadQuestions()
    {
        Stack<String> Qs = new Stack<String>();

        Qs.push("How many people live in the household");
        Qs.push("On average how long are you're showers?");
        Qs.push("How many litres of Water do you use (Per Month");
        Qs.push("What car do you have?");
        Qs.push("Is it HE?");
        Qs.push("How many times do you use the dishwasher per week?");
        Qs.push("Is it HE?");
        Qs.push("How many times do you use the Washing Machine per week?");
        Qs.push("About how many bulbs are in the house?");
        Qs.push("What kind of light bulbs do you use?");
        return Qs;

    }
    private void LoadScreen(TextView text, ImageView banner, Stack<String> q)
    {
        text.setText(q.pop());
        banner.setImageResource(R.drawable.cables);
    }
    private void LoadNext(Stack<String> q)
    {
        TextInputEditText val = findViewById(R.id.AnswerField);
        writeToFile(val.getText().toString(),this);
        Intent myIntent = new Intent(Question1.this, Question2.class);
        Question1.this.startActivity(myIntent);

    }
    private void Clear(Context context)
    {
      //  OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Answers.txt", Context.MODE_PRIVATE));
        //outputStreamWriter.write(" ");
        //outputStreamWriter.close();
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
