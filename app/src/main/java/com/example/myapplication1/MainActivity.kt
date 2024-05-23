package com.example.myapplication1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
    }

    private fun initComponents() {
        binding.num1.setOnClickListener {
            appendResult("1")
        }
        binding.num2.setOnClickListener {
            appendResult("2")
        }
        binding.num3.setOnClickListener {
            appendResult("3")
        }
        binding.num4.setOnClickListener {
            appendResult("4")
        }
        binding.num5.setOnClickListener {
            appendResult("5")
        }
        binding.num6.setOnClickListener {
            appendResult("6")
        }
        binding.num7.setOnClickListener {
            appendResult("7")
        }
        binding.num8.setOnClickListener {
            appendResult("8")
        }
        binding.num9.setOnClickListener {
            appendResult("9")
        }
        binding.num0.setOnClickListener {
            appendResult("0")
        }
        binding.point.setOnClickListener {
            appendResult(".")
        }
        binding.division.setOnClickListener {
            appendResult("/")
        }
        binding.multiplication.setOnClickListener {
            appendResult("x")
        }
        binding.minus.setOnClickListener {
            appendResult("-")
        }
        binding.addition.setOnClickListener {
            appendResult("+")
        }
        binding.equalsTo.setOnClickListener {

            var oldResult: String? = binding.result.text.toString()
            if (oldResult != null) {
                for (i in 0..oldResult.length-1){
                    if (binding.result.text.toString().contains("/")){
                        var firstNum: String? = binding.result.text.substring(0,oldResult.indexOf("/"))
                        var secondNum: String? = binding.result.text.substring(oldResult.indexOf("/")+1,oldResult.length)
                        var answer: Double = firstNum!!.toDouble() / secondNum!!.toDouble()
                        if(answer.rem(1).equals(0.00)) {
                            binding.result.setText(answer.toInt().toString())
                        }else{
                            binding.result.setText(answer.toString())
                        }
                    }
                    if (binding.result.text.toString().contains("x")){
                        var firstNum: String? = binding.result.text.substring(0,oldResult.indexOf("x"))
                        var secondNum: String? = binding.result.text.substring(oldResult.indexOf("x")+1,oldResult.length)
                        var answer: Double = firstNum!!.toDouble() * secondNum!!.toDouble()
                        if(answer.rem(1).equals(0.00)) {
                            binding.result.setText(answer.toInt().toString())
                        }else{
                            binding.result.setText(answer.toString())
                        }
                    }
                    if (binding.result.text.toString().contains("-")){
                        var firstNum: String? = binding.result.text.substring(0,oldResult.indexOf("-"))
                        var secondNum: String? = binding.result.text.substring(oldResult.indexOf("-")+1,oldResult.length)
                        var answer: Double = firstNum!!.toDouble() - secondNum!!.toDouble()
                        if(answer.rem(1).equals(0.00)) {
                            binding.result.setText(answer.toInt().toString())
                        }else{
                            binding.result.setText(answer.toString())
                        }
                    }
                    if (binding.result.text.toString().contains("+")){
                        var firstNum: String? = binding.result.text.substring(0,oldResult.indexOf("+"))
                        var secondNum: String? = binding.result.text.substring(oldResult.indexOf("+")+1,oldResult.length)
                        var answer: Double = firstNum!!.toDouble() + secondNum!!.toDouble()
                        if(answer.rem(1).equals(0.00)) {
                            binding.result.setText(answer.toInt().toString())
                        }else{
                            binding.result.setText(answer.toString())
                        }
                    }
                }

            }
        }
        binding.erase.setOnClickListener {
            var oldResult: String? = binding.result.text.toString()
            if (!oldResult.isNullOrEmpty()) {
                binding.result.setText(oldResult.substring(0, oldResult.length - 1))
            }
        }
        binding.eraseAll.setOnClickListener {
            var oldResult: String? = binding.result.text.toString()
            if (!oldResult.isNullOrEmpty()) {
                binding.result.setText("")
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun appendResult(s: String) {
        var oldResult: String? = binding.result.text.toString()
        binding.result.setText(oldResult + s)
    }


}