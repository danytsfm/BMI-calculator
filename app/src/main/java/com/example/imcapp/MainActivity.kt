package com.example.imcapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        btnCalcular?.setOnClickListener {
           calcularIMC(txtPeso.text.toString(), txtAltura.text.toString())
        }
    }

    private fun calcularIMC(peso:String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso != null && altura != null) {
            val imc = peso / (altura * altura)
                showDialogResult(imc)
        }

    }

    private fun showDialogResult(imc:Float){
        val finalMessage = when {
            imc < 18.5 -> "You are underweight :( \n \n $imc".format(imc)
            imc >= 25 -> "You are overweight :( \n \n $imc".format(imc)
            else -> "Keep up with the good health. You are doing great :) \n \n $imc".format(imc)
        }
        MaterialAlertDialogBuilder(this)
                .setTitle(resources.getString(R.string.titles))
                .setMessage(finalMessage)
                .setIcon(R.drawable.settings_accessibility_24px)
                .show()
    }

}