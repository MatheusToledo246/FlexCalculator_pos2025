package com.example.flexcalculator_pos2025

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var etFuel: TextInputLayout
    private lateinit var etFuel2: TextInputLayout
    private lateinit var etValue: TextInputLayout
    private lateinit var etValue2: TextInputLayout
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFuel = findViewById(R.id.etFuel)
        etFuel2 = findViewById(R.id.etFuel2)
        etValue = findViewById(R.id.etValue)
        etValue2 = findViewById(R.id.etValue2)
        tvResultado = findViewById(R.id.tvResultado)

        val btnCalcular: Button = findViewById(R.id.btResult)
        btnCalcular.setOnClickListener {
            btResultOnClick(it)
        }
    }

    fun btBuscarOnClick(view: View) {
        val intent = Intent(this, ListarActivity::class.java)
        getResult.launch(intent)
    }

    fun btBuscar2OnClick(view: View) {
        val intent = Intent(this, ListarActivity::class.java)
        getResult2.launch(intent)
    }

    private val getResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if ( it.resultCode == RESULT_OK){
            val codRetorno = it.data?.getIntExtra("codRetorno",0)
            etFuel.editText?.setText( codRetorno.toString())
        }
    }

    private val getResult2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if ( it.resultCode == RESULT_OK){
            val codRetorno = it.data?.getIntExtra("codRetorno",0)
            etFuel2.editText?.setText( codRetorno.toString())
        }
    }




    fun btResultOnClick(view: View) {
        val preco1 = etFuel.editText?.text.toString().toDoubleOrNull() ?:0.0
        val preco2 = etFuel2.editText?.text.toString().toDoubleOrNull() ?:0.0

        val valor1 = etValue.editText?.text.toString().toDoubleOrNull()?:0.0
        val valor2 = etValue2.editText?.text.toString().toDoubleOrNull()?:0.0


        val rendimento =  preco1 / valor1
        val rendimento2 = preco2 / valor2


        val resultado = if (rendimento > rendimento2) {
            "O Mais Vantajoso é: O combustivel 1!!!"
        } else if (rendimento < rendimento2) {
            "O Mais Vantajoso é: O combustivel 2!!!"
        } else {
            "Os combustíveis têm o mesmo rendimento."
        }

        tvResultado.text = resultado
    }

}
