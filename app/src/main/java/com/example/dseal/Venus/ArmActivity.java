package com.example.dseal.Venus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.telephony.SmsManager;

import com.example.dseal.Ivy.R;

import java.util.ArrayList;

public class ArmActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> numbers = (ArrayList<String>) getIntent().getSerializableExtra("numbers");
        String message = (String) getIntent().getSerializableExtra("message");
        String campSec = (String) getIntent().getSerializableExtra("campSec");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm);

        // SMS
        final String smsMessage = message;
        final SmsManager sms = SmsManager.getDefault();
        final ArrayList friendsNumbers = numbers;
        final String campSecNumber = campSec;
        final String userNumber = "";


        // Buttons
        final Button friends = findViewById(R.id.friends);
        final Button campusSaftey = findViewById(R.id.campusSaftey);
        final Button police = findViewById(R.id.police);
        Button set = findViewById(R.id.settings);

        // Button Functionality
        // Friends Button
        friends.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (Object friendNumber : friendsNumbers){
                    sms.sendTextMessage((String)friendNumber, userNumber, smsMessage, null, null);
                }
            }
        });

        // Campus Saftey Button
        campusSaftey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", campSecNumber, null)));
            }
        });

        // Police Button
        police.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "911", null)));
            }
        });

        // Settings Button
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newScreen2 = new Intent(ArmActivity.this, SettingsActivity.class);
                startActivity(newScreen2);
            }
        });
    }
}

