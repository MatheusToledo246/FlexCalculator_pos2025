package com.example.flexcalculator_pos2025

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListarActivity : AppCompatActivity() {

    private lateinit var lvCombustivel : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        lvCombustivel = findViewById(R.id.lvCombustivel)
        
        lvCombustivel.setOnItemClickListener { parent, view, position, id ->
            val itemSelecionadoId=  if ( position == 0){
                position + 11
            } else {
                position + 12
            }

            intent.putExtra( "codRetorno", itemSelecionadoId)
            setResult( RESULT_OK, intent )

            finish()
        }

    }
}