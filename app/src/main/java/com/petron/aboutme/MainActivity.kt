package com.petron.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { addNickname(it) }
        nickname_text.setOnClickListener { updateNickname(it) }
    }






    private fun addNickname(view: View){

        nickname_text.text = nickname_edit.text

        nickname_edit.visibility = View.GONE
        //button.visibility = View.GONE -- al meter el view: View
        // lo hacemos directamente desd ei view
        view.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE

        // Ocultar teclado
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)


    }

    private fun updateNickname (view: View) {
        nickname_edit.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
        view.visibility = View.GONE
        // Dar el foco al editText
        nickname_text.requestFocus()
        //Mostrar el teclado
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickname_edit, 0)

    }
}