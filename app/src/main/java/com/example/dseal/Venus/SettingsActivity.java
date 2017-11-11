package com.example.dseal.Venus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;


import com.example.dseal.Ivy.R;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    ArrayList<String> numbers = new ArrayList<>();
    String message;
    String campSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button save = findViewById(R.id.save);
        final ToggleButton locationToggle = findViewById(R.id.toggleButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campSec = (((EditText)findViewById(R.id.campsec)).getText().toString());
                message = (((EditText)findViewById(R.id.mssg)).getText().toString());
                numbers.add(((EditText)findViewById(R.id.ph1)).getText().toString());
                numbers.add(((EditText)findViewById(R.id.ph2)).getText().toString());
                numbers.add(((EditText)findViewById(R.id.ph3)).getText().toString());
                Intent intent = new Intent(SettingsActivity.this, ArmActivity.class);
                intent.putExtra("numbers",numbers);
                intent.putExtra("message",message);
                intent.putExtra("campSec",campSec);
                startActivity(intent);
            }
        });
    }


}
