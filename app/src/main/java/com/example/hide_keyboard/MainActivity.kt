package com.example.hide_keyboard

import androidx.appcompat.app.AppCompatActivity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // when user press our button then it will automatic close moblie keyboard.

    private var textViewResult: TextView? = null
    private var editTextInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.text_view_result)
        editTextInput = findViewById(R.id.edit_text_input)
    }
// onclick of button below function called
    fun setText(v: View) {
        val newText = editTextInput!!.text.toString()
        textViewResult!!.text = newText
// it will firstly set text of edit text to our text view and after that
    // closeKeyboard fuction will be work for close the keyboard.
        closeKeyboard()
    }

    private fun closeKeyboard() {

        // here we have created the view and get the current focus of window.
        // if view not null then our system will be get the system service
        // and after that it will close the keyboard.
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
