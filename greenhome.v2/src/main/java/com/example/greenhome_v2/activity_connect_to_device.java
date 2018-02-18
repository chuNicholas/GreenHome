package com.example.greenhome_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_connect_to_device extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_to_device);

        TextView text = findViewById(R.id.withText);
        text.setText("This section allows you to connect your smart devices with the App and sync " +
                "its settings in order to gain a better estimate of your ecological footprint.");

    }
}
