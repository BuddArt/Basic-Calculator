package org.hyperskill.calculator

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dispEditText = findViewById<EditText>(R.id.displayEditText)
        dispEditText.inputType = InputType.TYPE_NULL
        var firstTerm: Double = 0.0
        var secondTerm: Double = 0.0
        var result = ""
        var operation = 0
        var minus = 0

        findViewById<Button>(R.id.button0).setOnClickListener {
            if (dispEditText.text.toString() != "0") {
                dispEditText.append("0")
            }
        }

        findViewById<Button>(R.id.button1).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("1")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-1")
            } else dispEditText.append("1")
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("2")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-2")
            } else dispEditText.append("2")
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("3")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-3")
            } else dispEditText.append("3")
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("4")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-4")
            } else dispEditText.append("4")
        }

        findViewById<Button>(R.id.button5).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("5")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-5")
            } else dispEditText.append("5")
        }

        findViewById<Button>(R.id.button6).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("6")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-6")
            } else dispEditText.append("6")
        }

        findViewById<Button>(R.id.button7).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("7")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-7")
            } else dispEditText.append("7")
        }

        findViewById<Button>(R.id.button8).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("8")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-8")
            } else dispEditText.append("8")
        }

        findViewById<Button>(R.id.button9).setOnClickListener {
            if (dispEditText.text.toString() == "0") {
                dispEditText.setText("9")
            } else if (dispEditText.text.toString() == "-0") {
                dispEditText.setText("-9")
            } else dispEditText.append("9")
        }

        findViewById<Button>(R.id.clearButton).setOnClickListener {
            dispEditText.setText("")
            dispEditText.hint = "0"
            firstTerm = 0.0
            secondTerm = 0.0
            operation = 0
            result = ""
        }

        findViewById<Button>(R.id.dotButton).setOnClickListener {
            if (!dispEditText.text.toString().contains(".")) {
                if (dispEditText.text.toString() == "" || dispEditText.text.toString() == "-") {
                    dispEditText.append("0.")
                } else {
                    dispEditText.append(".")
                }
            }
        }

        findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            if (dispEditText.text.toString() != "") {
                firstTerm = dispEditText.text.toString().toDouble()
            } else if (dispEditText.text.toString() == "") {
                firstTerm = dispEditText.hint.toString().toDouble()
            }
            operation = 1
            val firstString = firstTerm.toString()
            if (firstString.last() == '0' && firstString[firstString.lastIndex - 1] == '.') {
                dispEditText.hint = firstString.dropLast(2)
            } else dispEditText.hint = firstString
            dispEditText.text.clear()
        }

        findViewById<Button>(R.id.addButton).setOnClickListener {
            if (dispEditText.text.toString().isNotEmpty()) {
                firstTerm = dispEditText.text.toString().toDouble()
            } else if (dispEditText.text.isEmpty()) {
                firstTerm = dispEditText.hint.toString().toDouble()
            }
            operation = 2
            val firstString = firstTerm.toString()
            if (firstString.last() == '0' && firstString[firstString.lastIndex - 1] == '.') {
                dispEditText.hint = firstString.dropLast(2)
            } else dispEditText.hint = firstString
            dispEditText.text.clear()
        }

        findViewById<Button>(R.id.divideButton).setOnClickListener {
            if (dispEditText.text.toString().isNotEmpty()) {
                firstTerm = dispEditText.text.toString().toDouble()
            } else if (dispEditText.text.isEmpty()) {
                firstTerm = dispEditText.hint.toString().toDouble()
            }
            operation = 3
            val firstString = firstTerm.toString()
            if (firstString.last() == '0' && firstString[firstString.lastIndex - 1] == '.') {
                dispEditText.hint = firstString.dropLast(2)
            } else dispEditText.hint = firstString
            dispEditText.text.clear()
        }

        try {
            findViewById<Button>(R.id.subtractButton).setOnClickListener {
                if ((dispEditText.hint.toString() == "0" && dispEditText.text.isEmpty() && operation == 4 && minus == 1) || (dispEditText.text.isEmpty() && operation != 0 && result == "") || (dispEditText.text.isEmpty() && dispEditText.hint.toString() == "0" && result == "")) {
                    dispEditText.setText("-")
                } else {
                    if (dispEditText.text.isNotEmpty()) {
                        if (dispEditText.text.toString() == "-") {
                            firstTerm = "-0".toDouble()
                        } else firstTerm = dispEditText.text.toString().toDouble()
                    } else if (dispEditText.text.isEmpty()) {
                        firstTerm = dispEditText.hint.toString().toDouble()
                    }
                    operation = 4
                    val firstString = firstTerm.toString()
                    if (firstString.last() == '0' && firstString[firstString.lastIndex - 1] == '.') {
                        dispEditText.hint = firstString.dropLast(2)
                    } else dispEditText.hint = firstString
                    dispEditText.text.clear()
                }
                minus = 1
            }
        } catch(e: NumberFormatException) {}

                findViewById<Button>(R.id.equalButton).setOnClickListener {
                    if (dispEditText.text.isEmpty() && firstTerm != 0.0) {
                        secondTerm = firstTerm
                        when (operation) {
                            1 -> result = multi(firstTerm, secondTerm)
                            2 -> result = add(firstTerm, secondTerm)
                            3 -> result = div(firstTerm, secondTerm)
                            4 -> result = subtr(firstTerm, secondTerm)
                        }
                        operation = 0
                        firstTerm = 0.0
                        if (result.last() == '0' && result[result.lastIndex - 1] == '.') {
                            dispEditText.hint = result.dropLast(2)
                        } else dispEditText.hint = result
                        dispEditText.text.clear()
                    } else if (dispEditText.text.isEmpty() && firstTerm == 0.0) {
                        firstTerm = result.toDouble()
                        secondTerm = secondTerm
                        when (operation) {
                            1 -> result = multi(firstTerm, secondTerm)
                            2 -> result = add(firstTerm, secondTerm)
                            3 -> result = div(firstTerm, secondTerm)
                            4 -> result = subtr(firstTerm, secondTerm)
                        }
                        firstTerm = 0.0
                        if (result.last() == '0' && result[result.lastIndex - 1] == '.') {
                            dispEditText.hint = result.dropLast(2)
                        } else dispEditText.hint = result
                        dispEditText.text.clear()
                    } else if (dispEditText.text.isNotEmpty()) {
                        secondTerm = dispEditText.text.toString().toDouble()
                        when (operation) {
                            1 -> result = multi(firstTerm, secondTerm)
                            2 -> result = add(firstTerm, secondTerm)
                            3 -> result = div(firstTerm, secondTerm)
                            4 -> result = subtr(firstTerm, secondTerm)
                        }
                        minus = 0
                        firstTerm = 0.0
                        if (result.last() == '0' && result[result.lastIndex - 1] == '.') {
                            dispEditText.hint = result.dropLast(2)
                        } else dispEditText.hint = result
                        dispEditText.text.clear()
                    }
                }
    }

    private fun multi(ft: Double, st: Double): String {
        val result = ft * st
        return result.toString()
    }

    private fun add(ft: Double, st: Double): String {
        val result = ft + st
        return result.toString()
    }

    private fun subtr(ft: Double, st: Double): String {
        val result = ft - st
        return result.toString()
    }

    fun div(ft: Double, st: Double): String {
        val result = ft / st
        return result.toString()
    }
}
