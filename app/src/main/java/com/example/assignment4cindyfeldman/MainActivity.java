package com.example.assignment4cindyfeldman;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    LinearLayout mainLayout = null;
    Button startButton = null;
    int ButtonCount = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainLayout);
        startButton = findViewById(R.id.startButton);
       startButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               generateNewButton();
               startButton.setEnabled(false);
           }
       });


    }
    private void generateNewButton() {
// Generates a new Button widget dynamically.
// 1. Set the layout params


        final Button button = new Button(this);



        LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParam);
        button.setText("PRESS ME: " + Integer.toString(++ButtonCount));
        button.setBackgroundColor(getRandomColor());
        button.setTextColor(getRandomColor());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewButton();
                button.setEnabled(false);
            }
        });
        mainLayout.addView(button);
// 2. Create the button and define the look (i.e. text, text
        //color, etc.)
// 3. Create a callback that will generate another widget.
// 4. Disable the last button.
    }
    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
        }

