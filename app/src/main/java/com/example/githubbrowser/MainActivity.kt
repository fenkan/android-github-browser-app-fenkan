package com.example.githubbrowser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener {

    //defining the views
    private var editTextUsername: EditText? = null
    private var progressBar: ProgressBar? = null
    private var imm: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the variables
        editTextUsername = findViewById(R.id.editTextUsername)
        progressBar = findViewById(R.id.progressBar)

        // Initializing the imm
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Setting editText listener
        editTextUsername?.setOnEditorActionListener(this)

    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
       return if (p0 == editTextUsername) {

           //Get the username from the edit text
               val username = editTextUsername?.text?.trim().toString()

           //Check if the edit text is not empty
            if (username.isEmpty() || username.isBlank()) {
                //Show an error message to the user
                editTextUsername?.error = getString(R.string.username_cannot_be_empty)
            }else {
                //Hide the keyboard
                imm?.hideSoftInputFromWindow(editTextUsername?.windowToken, 0)

                //Start the progress bar
                progressBar?.visibility = View.VISIBLE

                //Make the request
                getRepositoriesForUsername(username)
            }



             true
        }else {
             false
        }
    }
    private fun getRepositoriesForUsername(username: String) {

    }


}