package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView name,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name_text_view);
        contact = findViewById(R.id.contact_text_view);

        name.setText(getIntent().getStringExtra("name"));
        contact.setText(getIntent().getStringExtra("contact"));

    }
}
