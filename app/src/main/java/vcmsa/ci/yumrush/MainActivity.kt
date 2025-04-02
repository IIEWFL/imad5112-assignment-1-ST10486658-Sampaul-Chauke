/*Code Attribution
This code was taken from the IMAD5112 Module Manual pages 53-56
  https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
  Varsity College IIE
     */
package vcmsa.ci.yumrush

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Current Fields
    private lateinit var userText: EditText
    private lateinit var btnSuggest: Button
    private lateinit var btnClear: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Assigning variables to their id
        val output = findViewById<TextView>(R.id.txtOutput)
        userText = findViewById(R.id.userText)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnClear = findViewById(R.id.btnclear)

        //Suggest button listener
        btnSuggest.setOnClickListener {
            val userInput = userText.text.toString().trim().lowercase()
            if (userInput.isEmpty()) {
                userText.error = "Please enter time of day"
                output.text = ""
            } else {
                val suggestFood = suggestFood(userInput)
                output.text = "$suggestFood"
                userText.error = null

            }
        }
        //Clear button listener
        btnClear.setOnClickListener {
            userText.text.clear() //Clear the input field
            output.text = "" // Clear the output
        }
    }

    // Function to suggest food based on the time of day
    private fun suggestFood(userInput: String): String {
        return when (userInput) {
            "morning" -> "Eggs"
            "mid-morning" -> "Sandwich"
            "afternoon" -> "Salad"
            "mid-afternoon" -> "Fruit"
            "dinner" -> "Grilled Chicken"
            "mid-dinner" -> "Yogurt"
            else -> "Invalid data Enter please enter(E.G morning,mid-morning and etc)"

        }
    }
}
