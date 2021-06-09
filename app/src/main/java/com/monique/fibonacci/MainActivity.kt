package com.monique.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var userInput: EditText
    lateinit var result: TextView
    lateinit var button: Button
    val fibList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInput = findViewById(R.id.userInput)
        result = findViewById(R.id.resultComponent)
        button = findViewById(R.id.calculate)

        button.setOnClickListener{
            val turnsStr = userInput.text.toString()

            if(turnsStr.isNotEmpty()){
                val turns = turnsStr.toInt()
                fibonacci(turns)
                fibList.clear()
            }else{
                userInput.error ="Digite um valor"
            }

        }

    }

    fun fibonacci(turns: Int) {
        var t1:Long = 0
        var t2:Long = 1

        for (i in 1..turns) {
            fibList.add(t1.toString())
            val sum = t1 + t2
            t1 = t2
            t2 = sum
        }
        showList()
    }

    fun showList(){
        var showElements = ""

        result.visibility = View.VISIBLE

        for(element in fibList){
            if(element == fibList.last() && element != "1"){
                showElements += "${element}"
            }else{
                showElements += "${element}, "
            }
        }
        result.text = showElements

    }

}