package com.example.uasml2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SimulasiModelActivity : AppCompatActivity() {

    private lateinit var ageEditText: EditText
    private lateinit var chestPainTypeEditText: EditText
    private lateinit var cholesterolEditText: EditText
    private lateinit var exerciseAnginaEditText: EditText
    private lateinit var stDepressionEditText: EditText
    private lateinit var slopeOfSTEditText: EditText
    private lateinit var thalliumEditText: EditText
    private lateinit var predictButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulasi_model)

        // Initialize views
        ageEditText = findViewById(R.id.age)
        chestPainTypeEditText = findViewById(R.id.chestPainType)
        cholesterolEditText = findViewById(R.id.cholesterol)
        exerciseAnginaEditText = findViewById(R.id.exerciseAngina)
        stDepressionEditText = findViewById(R.id.stDepression)
        slopeOfSTEditText = findViewById(R.id.slopeOfST)
        thalliumEditText = findViewById(R.id.thallium)
        predictButton = findViewById(R.id.btnCheck)
        resultTextView = findViewById(R.id.txtResult)

        // Set click listener for Predict button
        predictButton.setOnClickListener {
            predict()
        }
    }

    private fun predict() {
        // Get values from EditText fields
        val age = ageEditText.text.toString().toIntOrNull() ?: 0
        val chestPainType = chestPainTypeEditText.text.toString().toIntOrNull() ?: 0
        val cholesterol = cholesterolEditText.text.toString().toDoubleOrNull() ?: 0.0
        val exerciseAngina = exerciseAnginaEditText.text.toString().toIntOrNull() ?: 0
        val stDepression = stDepressionEditText.text.toString().toDoubleOrNull() ?: 0.0
        val slopeOfST = slopeOfSTEditText.text.toString().toIntOrNull() ?: 0
        val thallium = thalliumEditText.text.toString().toIntOrNull() ?: 0

        // Perform your prediction logic here based on input values
        val predictionResult = performPrediction(age, chestPainType, cholesterol, exerciseAngina, stDepression, slopeOfST, thallium)

        // Display result in TextView
        resultTextView.text = "Prediction result: $predictionResult"
    }

    private fun performPrediction(age: Int, chestPainType: Int, cholesterol: Double, exerciseAngina: Int,
                                  stDepression: Double, slopeOfST: Int, thallium: Int): String {
        // Example dummy logic: predicting based on some thresholds
        val isAffected = (age > 40 && chestPainType == 1 && cholesterol > 200 && exerciseAngina == 1)
                || (stDepression > 2.0 && slopeOfST == 2 && thallium == 3)

        return if (isAffected) "Affected" else "Not affected"
    }
}


