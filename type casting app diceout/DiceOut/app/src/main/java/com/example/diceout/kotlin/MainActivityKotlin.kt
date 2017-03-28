package com.example.diceout.kotlin

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.util.*

/**
 * Created by xboxm on 12-02-2017.
 */

class MainActivityKotlin : Activity() {

    lateinit var rollResult : TextView

    //Field to hold the roll button
    lateinit var rollButton: Button

    // Field to hold the score
    internal var score: Int = 0

    // Field to hold the text view
    lateinit var scoreText: TextView

    // Field to hold the dice values
    var die1: Int = 0
    var die2:Int = 0
    var die3:Int = 0

    // ArrayList to hold all three dice values
    lateinit var dice: ArrayList<Int>

    // ArrayList to hold all three dice images
    lateinit var diceImageViews: ArrayList<ImageView>

    lateinit var rand: Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollResult = findViewById(R.id.rollResult) as TextView

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> rollDice(view) }
        val ng = findViewById(R.id.newgame) as Button
        ng.setOnClickListener { view -> newgame() }

        // Set initial score
        score = 0

        rollResult = findViewById(R.id.rollResult) as TextView
        scoreText = findViewById(R.id.scoreText) as TextView

        // Create greeting
        Toast.makeText(applicationContext, "Welcome to DiceOut written in Kotlin!", Toast.LENGTH_SHORT).show()

        rand = Random()

        // Create ArrayList container for all dice values
        dice = ArrayList<Int>()

        val die1Image = findViewById(R.id.die1Image) as ImageView
        val die2Image = findViewById(R.id.die2Image) as ImageView
        val die3Image = findViewById(R.id.die3Image) as ImageView

        diceImageViews = ArrayList<ImageView>()
        if (die1Image is ImageView) {
            diceImageViews.add(die1Image)
        }
        if (die1Image is ImageView) {
            diceImageViews.add(die2Image)
        }
        if (die1Image is ImageView) {
            diceImageViews.add(die3Image)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    fun rollDice(v: Any?) {

        if (v is View) {
            rollResult.text = "Clicked!"

            // Roll dice
            die1 = rand.nextInt(6) + 1
            die2 = rand.nextInt(6) + 1
            die3 = rand.nextInt(6) + 1

            //Set dice values into an arraylist but clear first
            dice.clear()
            dice.add(die1)
            dice.add(die2)
            dice.add(die3)

            setDiceImages()
            checkIfWonPoints()
        }
    }

    private fun setDiceImages() {
        for (dieOfSet in 0..2) {
            val imagename = "die_" + dice[dieOfSet] + ".png"

            try {
                val stream = assets.open(imagename)
                val d = Drawable.createFromStream(stream, null)
                diceImageViews[dieOfSet].setImageDrawable(d)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    private fun checkIfWonPoints() {
        // Build message with the result
        var msg: String

        if (die1 == die2 && die1 == die3) {
            //Triples
            val scoreDelta = die1 * 100
            msg = "You rolled a triple $die1! You score $scoreDelta points!"
            score += scoreDelta
        } else if (die1 == die2 || die1 == die3 || die2 == die3) {
            // Double
            msg = "You rolled doubles for 50 points"
            score += 50
        } else {
            msg = "You didn't score this roll. Try again!"
        }

        // Update the app to display the message
        rollResult.text = msg
        scoreText.text = "Score: " + score
    }

    private fun newgame() {
        var msg : String
        score = 0
        rollResult.text = "Let's Play!"
        scoreText.text = "Score: " + score
    }



}