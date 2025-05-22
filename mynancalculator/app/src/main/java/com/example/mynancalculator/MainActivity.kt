package com.example.mynancalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timeSpinner: Spinner
    private lateinit var moodSpinner: Spinner
    private lateinit var suggestButton: Button
    private lateinit var resultText: TextView

    private val snackMap = mapOf(
        "Morning" to mapOf(
            "Tired" to "Oatmeal with banana and coffee",
            "Happy" to "Fruit smoothie and granola",
            "Sad" to "Warm toast with peanut butter",
            "Stressed" to "Greek yogurt with honey",
            "Hungry" to "Egg wrap with avocado",
            "Bored" to "Protein bar and tea"
        ),
        "Afternoon" to mapOf(
            "Tired" to "Protein shake and almonds",
            "Happy" to "Trail mix and sparkling water",
            "Sad" to "Chocolate protein ball",
            "Stressed" to "Crunchy almonds & a protein shake",
            "Hungry" to "Chicken wrap or hummus and pita",
            "Bored" to "Popcorn and fruit"
        ),
        "Evening" to mapOf(
            "Tired" to "Boiled eggs and herbal tea",
            "Happy" to "Rice cakes with peanut butter",
            "Sad" to "Dark chocolate and strawberries",
            "Stressed" to "Low-fat cheese and crackers",
            "Hungry" to "Protein-rich soup",
            "Bored" to "Yogurt and berries"
        ),
        "Late Night" to mapOf(
            "Tired" to "Warm milk and banana",
            "Happy" to "Nut butter on toast",
            "Sad" to "Cottage cheese and pineapple",
            "Stressed" to "Herbal tea and rice cakes",
            "Hungry" to "Oats with almond milk",
            "Bored" to "Carrot sticks and hummus"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeSpinner = findViewById(R.id.timeSpinner)
        moodSpinner = findViewById(R.id.moodSpinner)
        suggestButton = findViewById(R.id.suggestButton)
        resultText = findViewById(R.id.resultText)

        val timeOptions = listOf("Morning", "Afternoon", "Evening", "Late Night")
        val moodOptions = listOf("Tired", "Happy", "Sad", "Stressed", "Hungry", "Bored")

        timeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, timeOptions)
        moodSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, moodOptions)

        suggestButton.setOnClickListener {
            val time = timeSpinner.selectedItem.toString()
            val mood = moodSpinner.selectedItem.toString()
            val snack = snackMap[time]?.get(mood) ?: "No snack found"
            resultText.text = "Snack Suggestion: $snack"
        }

        showInstructionsPopup()
    }

    private fun showInstructionsPopup() {
        AlertDialog.Builder(this)
            .setTitle("How to Use")
            .setMessage("Select the time of day and your current mood, then tap 'Suggest Snack' to get a personalized recommendation.")
            .setPositiveButton("Got it!") { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .show()
    }
}
