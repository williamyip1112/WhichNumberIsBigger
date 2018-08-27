package com.example.per2.whichnumberisbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //instance variables for the widgets we need to
    //access program
    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private int score;
    private int leftNum;
    private int rightNum;
    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        randomizeAndUpdateDisplay();
    }

    private void wireWidgets()
    {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textview_main_score);
    }
    private void randomizeAndUpdateDisplay()
    {

        String scoreString = getResources().getString(R.string.main_score);
        textViewScore.setText(scoreString + score);
        randomizedNumbers();
        buttonLeft.setText(String.valueOf(leftNum));
        buttonRight.setText(String.valueOf(rightNum));
    }
    private void randomizedNumbers()
    {
        //generate a random number for the left
        int range = MAX_NUM - MIN_NUM + 1;
        leftNum = MIN_NUM + (int) (Math.random() * range);
        rightNum = MIN_NUM + (int) (Math.random() * range);

        while (leftNum == rightNum)
        {
            rightNum = genNumber();
        }
    }
    private int genNumber()
    {
        int range = MAX_NUM - MIN_NUM + 1;
        return MIN_NUM + (int)(Math.random() * range);

    }

    public void onLeftClick(View view)
    {
        checkAnswer(true);
    }


    public void onRightClick(View view) {
        checkAnswer(false);
    }
    public void checkAnswer( boolean leftPressed) {
        String message;
        if ((leftNum > rightNum && leftPressed) || (rightNum > leftNum && !leftPressed)) {
            score++;
            message = "Correct :)";
        } else {
            score--;
            message = "Bruh -_-";
        }
        randomizeAndUpdateDisplay();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }




    }




