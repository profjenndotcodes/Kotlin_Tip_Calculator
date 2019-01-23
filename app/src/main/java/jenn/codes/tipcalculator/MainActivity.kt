package jenn.codes.tipcalculator

import android.icu.text.NumberFormat
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val currencyFormat = NumberFormat.getCurrencyInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcTipButton = findViewById<Button>(R.id.btnCalc)
        val resultText = findViewById<TextView>(R.id.txtResult)

        calcTipButton.setOnClickListener {
            resultText.setText(currencyFormat.format(7.89645).toString())

            // Hide the keyboard.
            //val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //imm.hideSoftInputFromWindow(view.windowToken, 0)
        }


    }
}
