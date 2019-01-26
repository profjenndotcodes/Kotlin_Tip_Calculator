package jenn.codes.tipcalculator

import android.icu.text.NumberFormat
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    private val currencyFormat = NumberFormat.getCurrencyInstance()
    private var tipPercent = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.wtf("JENN","Gets to here")
        val calcTipButton = findViewById<Button>(R.id.btnCalc)
        val resultText = findViewById<TextView>(R.id.txtTotalAmount)
        val spinner: Spinner = findViewById(R.id.spnTipAmount)
        val edtCheckAmount: EditText = findViewById(R.id.edtCheckAmount)
        val txtTipAmount: TextView = findViewById(R.id.txtTipAmount)

        ArrayAdapter.createFromResource(
            this,
            R.array.tip_amount_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
            Log.d("GETS TO HERE","Gets to here")
        }

        calcTipButton.setOnClickListener {
            if (edtCheckAmount.text.toString().trim().isNotEmpty() ){
                var chkAmount = edtCheckAmount.text.toString().toDouble()
                var tipAmount = chkAmount * tipPercent
                var totalAmount = chkAmount + tipAmount

                resultText.setText(currencyFormat.format(totalAmount).toString())
                txtTipAmount.setText(currencyFormat.format(tipAmount).toString())


            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.d("JENNTAG","Nothing Selected")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p2)
        {
            1 -> tipPercent = .1
            2 -> tipPercent = .15
            3 -> tipPercent = .2
        }
    }
}
