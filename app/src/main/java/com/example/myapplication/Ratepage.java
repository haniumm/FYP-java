package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;
import com.hsalf.smileyrating.SmileyRating;

public class Ratepage extends AppCompatActivity {
    private Button back;
// mil gaya masla :
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratepage);
        //rate page button
        back =(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomepage();
            }
        });


        SmileyRating smileRating= findViewById(R.id.smile_rating);
        smileRating.setSmileySelectedListener(new SmileyRating.OnSmileySelectedListener() {
            @Override
            public void onSmileySelected(SmileyRating.Type type) {

            }
        });

    }

    public void openhomepage(){
        Intent intent= new Intent(this, Homepage.class);
        startActivity(intent);
    }


}
