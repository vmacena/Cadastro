package com.ifsp.cadastro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val etNomeCompleto: EditText =
            findViewById(R.id.etNomeCompleto)
        val etTelefone: EditText =
            findViewById(R.id.etTelefone)
        val etEmail: EditText =
            findViewById(R.id.etEmail)
        val cbListaEmails: CheckBox =
            findViewById(R.id.cbListaEmails)
        val rgSexo: RadioGroup =
            findViewById(R.id.rgSexo)
        val etCidade: EditText =
            findViewById(R.id.etCidade)
        val spUf: Spinner =
            findViewById(R.id.spUf)
        val btnLimpar: Button =
            findViewById(R.id.btnLimpar)
        val btnSalvar: Button =
            findViewById(R.id.btnSalvar)

        val estados =
            resources.getStringArray(R.array.estados_brasil)
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spUf.adapter = adapter

        btnSalvar.setOnClickListener {
            val nomeCompleto =
                etNomeCompleto.text.toString()
            val telefone =
                etTelefone.text.toString()
            val email =
                etEmail.text.toString()
            val ingressarListaEmails =
                cbListaEmails.isChecked
            val sexo =
                when (rgSexo.checkedRadioButtonId) {
                R.id.rbMasculino -> "Masculino"
                R.id.rbFeminino -> "Feminino"
                else -> ""
            }
            val cidade =
                etCidade.text.toString()
            val uf =
                spUf.selectedItem.toString()

            val formulario = Formulario(nomeCompleto, telefone, email, ingressarListaEmails, sexo, cidade, uf)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        btnLimpar.setOnClickListener {
            etNomeCompleto.text.clear()
            etTelefone.text.clear()
            etEmail.text.clear()
            cbListaEmails.isChecked = false
            rgSexo.clearCheck()
            etCidade.text.clear()
            spUf.setSelection(0)
        }
    }
}