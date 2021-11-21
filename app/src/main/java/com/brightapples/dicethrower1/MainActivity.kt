package com.brightapples.dicethrower1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Roll buttons defined
        val rollButton: Button = findViewById(R.id.rollButton)
        val rollButton2: Button = findViewById(R.id.rollButton2)

        /**
         * When roll button is clicked
         * 1. Rolls dice and returns the rolled dice image and number facing up
         * 2. shows a toast "Dice Rolled"
         */
        rollButton.setOnClickListener {
            rollDice(1)
            showToast("Dice 1 Rolled")
        }

        rollButton2.setOnClickListener {
            rollDice(2)
            showToast("Dice 2 Rolled")
        }

        // Do a dice roll when the app starts up
        rollDice(1)
        rollDice(2)
    }

    // Creates a toast
    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * Creates a dice object
     * rolls the dice
     * updates ImageView and TextView
     */
    private fun rollDice(id: Int) {

        when (id) {
            1 -> {
                val dice = Dice(6)
                val diceRoll = dice.roll()
                val resultTextView: TextView = findViewById(R.id.resultText)
                resultTextView.setText(diceRoll.toString())

                val diceImageView: ImageView = findViewById(R.id.diceImage)
                val drawableResource = when (diceRoll) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
                diceImageView.setImageResource(drawableResource)
                diceImageView.contentDescription = diceRoll.toString()
            }
            2 -> {
                val dice = Dice(6)
                val diceRoll = dice.roll()
                val resultTextView: TextView = findViewById(R.id.resultText2)
                resultTextView.setText(diceRoll.toString())

                val diceImageView: ImageView = findViewById(R.id.diceImage2)
                val drawableResource = when (diceRoll) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
                diceImageView.setImageResource(drawableResource)
                diceImageView.contentDescription = diceRoll.toString()
            }

        }


    }

}

/**
 * Class for Dice objects
 * params: number of sides
 * method to roll the dice
 */
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}