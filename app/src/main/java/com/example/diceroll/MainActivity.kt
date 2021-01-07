package com.example.diceroll

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice()
    {
        val dice1 = Dice(6)
        val diceValue = dice1.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.contentDescription = diceValue.toString()
        val drawableResource = when (diceValue)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Toast.makeText(applicationContext, "${diceValue}", Toast.LENGTH_SHORT).show()
        diceImage.setImageResource (drawableResource)
    }
}

class Dice (val numSides: Int)
{
    fun roll(): Int {return (1..numSides).random()}
}