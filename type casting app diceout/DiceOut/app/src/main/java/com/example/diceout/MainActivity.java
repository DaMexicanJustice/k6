package com.example.diceout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diceout.kotlin.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Field to hold the roll result text
    TextView rollResult;

    //Field to hold the roll button
    Button rollButton;

    // Field to hold the score
    int score;

    // Field to hold the text view
    TextView scoreText;

    // Field to hold the dice values
    int die1, die2, die3;

    // ArrayList to hold all three dice values
    ArrayList<Integer> dice;

    // ArrayList to hold all three dice images
    ArrayList<ImageView> diceImageViews;

    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice(view);
            }
        });

        // Set initial score
        score = 0;

        rollResult = (TextView) findViewById(R.id.rollResult);
        scoreText = (TextView) findViewById(R.id.scoreText);

        // Create greeting
        Toast.makeText(getApplicationContext(), "Welcome to DiceOut written in Java!", Toast.LENGTH_SHORT).show();

        rand = new Random();

        // Create ArrayList container for all dice values
        dice = new ArrayList<>();

        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);

        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void rollDice(View v) {

        rollResult.setText("Clicked!");

        // Roll dice
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        //Set dice values into an arraylist but clear first
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        setDiceImages();
        checkIfWonPoints();

    }

    private void setDiceImages() {
        for (int dieOfSet = 0; dieOfSet < 3; dieOfSet++) {
            String imagename = "die_" + dice.get(dieOfSet) + ".png";

            try {
                InputStream stream = getAssets().open(imagename);
                Drawable d = Drawable.createFromStream(stream, null);
                diceImageViews.get(dieOfSet).setImageDrawable(d);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkIfWonPoints() {
        // Build message with the result
        String msg;

        if (die1 == die2 && die1 == die3) {
            //Triples
            int scoreDelta = die1 * 100;
            msg = "You rolled a triple " +die1 + "! You score " + scoreDelta + " points!";
            score += scoreDelta;
        } else if (die1 == die2 || die1 == die3 || die2 == die3) {
            // Double
            msg = "You rolled doubles for 50 points";
            score += 50;
        } else {
            msg = "You didn't score this roll. Try again!";
        }

        // Update the app to display the message
        rollResult.setText(msg);
        scoreText.setText("Score: " + score);
    }
}
