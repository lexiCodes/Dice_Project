package com.example.demouser.dice_project;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private Random rand = new Random();
    ImageView diceImageView;
    TextView usersScore, computersScore, currentTurnsScore;
    Button roll, hold, reset;
    Resources res;
    Boolean yourTurn = false;

    private int userOverallScore = 0;

    private int usersTurnScore = 0;

    private int computersOverallScore = 0;

    private int computersTurnsScore = 0;

    private int result = 0;
    private int currRoll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        diceImageView = findViewById(R.id.diceImage);

        usersScore = findViewById(R.id.UsersScore);

        computersScore = findViewById(R.id.ComputersScore);

        currentTurnsScore = findViewById(R.id.CurrentTurnsScore);// status

        roll = findViewById(R.id.Roll);

        hold = findViewById(R.id.Hold);

        reset = findViewById(R.id.Reset);

        res = getResources();

        // diceImageView = diceImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice1));


        roll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

//                result;
                int currRoll;
                currRoll = rollDie();
                while (yourTurn)
                {
                    result += currRoll;
                    currentTurnsScore.setText("Current Turn Score: " + result);
                }
            }
        });

    }

        private int rollDie()
        {
            int result = rand.nextInt(6) + 1;
            switch (result)
            {
                case 1:
//                    diceImageView.setImageDrawable(res.getDrawable(R.drawable.dice1)); can use if you don't mind about the through line
                    diceImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice1));
                    break;
                case 2:
                    diceImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice2));
                    break;
                case 3:
                    diceImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice3));
                    break;
                case 4:
                    diceImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice4));
                    break;
                case 5:
                    diceImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice5));
                    break;
                case 6:
                    diceImageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice6));
                    break;
            }
            return result;
        }

}

