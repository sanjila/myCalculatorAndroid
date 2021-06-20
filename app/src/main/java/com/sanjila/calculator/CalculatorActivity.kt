package com.sanjila.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {
    // binding
    private lateinit var tvExpression: TextView
    private lateinit var tvResult: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnPlusMinus: Button
    private lateinit var btnPercent: Button

    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button

    private lateinit var btnEquals: Button
    private lateinit var btnAC: Button
    private lateinit var btnDot: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)

        btnDot = findViewById(R.id.btnDot)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        btnPlusMinus = findViewById(R.id.btnPlusMinus)
        btnPercent = findViewById(R.id.btnPercent)

        btnEquals = findViewById(R.id.btnEquals)
        btnAC = findViewById(R.id.btnAC)
        tvResult = findViewById(R.id.tvResult)
        tvExpression = findViewById(R.id.tvExpression)
    }

    var newOperator = true
    var dot = false

    //Function for number input
    fun btnNumberEvent(view: View) {
        if (newOperator) {
            tvResult.setText("")
        }
        newOperator = false
        val btnSelected = view as Button
        var clickedValue: String = tvResult.text.toString()
        var clickedValue1: String = tvExpression.text.toString()
        when (btnSelected.id) {
            btn0.id -> {
                clickedValue += "0"
                clickedValue1 = "0"
            }
            btn1.id -> {
                clickedValue += "1"
                clickedValue1 = "1"
            }
            btn2.id -> {
                clickedValue += "2"
                clickedValue1 = "2"
            }
            btn3.id -> {
                clickedValue += "3"
                clickedValue1 = "3"
            }
            btn4.id -> {
                clickedValue += "4"
                clickedValue1 = "4"
            }
            btn5.id -> {
                clickedValue += "5"
                clickedValue1 = "5"
            }
            btn6.id -> {
                clickedValue += "6"
                clickedValue1 = "6"
            }
            btn7.id -> {
                clickedValue += "7"
                clickedValue1 = "7"
            }
            btn8.id -> {
                clickedValue += "8"
                clickedValue1 = "8"
            }
            btn9.id -> {
                clickedValue += "9"
                clickedValue1 = "9"
            }
            btnDot.id -> {
                if (dot == false) {
                    clickedValue += "."
                    clickedValue1 = "."
                }
                dot = true
            }

            btnPlusMinus.id -> {
                clickedValue = "-" + clickedValue
                tvExpression.setText("")
                clickedValue1 = "-" + clickedValue1
            }
        }
        tvExpression.append(clickedValue1)
        tvResult.setText(clickedValue)
    }

    var operator = "*"
    var firstInput = ""

    //function for the operators
    fun btnOperatorEvent(view: View) {
        val btnSelected = view as Button
        when (btnSelected.id) {
            btnAdd.id -> {
                operator = "+"
            }
            btnSub.id -> {
                operator = "-"
            }
            btnMul.id -> {
                operator = "*"
            }
            btnDiv.id -> {
                operator="÷"
            }
        }
        firstInput = tvResult.text.toString()
        tvExpression.append(operator)
        newOperator = true
        dot = false
    }

    //function to calculate the final result
    fun btnEqualsEvent(view: View) {
        val newNumber = tvResult.text.toString()
        var finalResult: Double? = null
        when (operator) {
            "*" -> {
                finalResult = firstInput.toDouble() * newNumber.toDouble()
            }
            "÷" -> {
                finalResult = firstInput.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalResult = firstInput.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalResult = firstInput.toDouble() + newNumber.toDouble()
            }
        }
        tvResult.setText(finalResult.toString())
        //for the expression
        ExpressionBuilder(tvExpression.text.toString()).build()
        newOperator = true
    }

    //function to calculate the percentage
    fun btnPercentEvent(view: View) {
        val number = (tvResult.text.toString().toDouble()) / 100
        tvResult.setText(number.toString())
        newOperator = true
    }

    // function to clear the data
    fun btnClear(view: View) {
        tvResult.setText("")
        tvExpression.setText("")
        newOperator = true
        dot = false
    }
}


