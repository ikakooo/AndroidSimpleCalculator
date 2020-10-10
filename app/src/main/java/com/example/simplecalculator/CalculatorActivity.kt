package com.example.simplecalculator


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*



class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        init()
    }

    private fun init() {
        PlusButtonID.customOnClickAction()
        MinusButtonID.customOnClickAction()
        MultiplicationButtonID.customOnClickAction()
        DivisionButtonID.customOnClickAction()

    }


    private fun Button.customOnClickAction() {
        setOnClickListener {

            if ( firstNumberEditTextID.text.isNotEmpty() && secondNumberEditTextID.text.isNotEmpty()) {
                val firsNum = firstNumberEditTextID.text.toString()
                val secondNum = secondNumberEditTextID.text.toString()
                val operator = text.toString()[0]
                val sumOfToValue = operatorFromChar(operator).invoke(firsNum.toFloat(),secondNum.toFloat())
                runResultActivity("$firsNum $operator $secondNum = $sumOfToValue" )
            } else {
                Toast.makeText(this@CalculatorActivity, "Please enter both numbers", Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun runResultActivity(result:String) {
        val intent = Intent(this@CalculatorActivity, ResultActivity::class.java)
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("resultID", result)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }




    private fun operatorFromChar(charOperator: Char):(Float, Float)->Float {
        return when(charOperator)
        {
            '+'->{a,b->a+b}
            '-'->{a,b->a-b}
            '/'->{a,b->a/b}
            '*'->{a,b->a*b}
            else -> throw Exception("That's not a supported operator")
        }
    }
}