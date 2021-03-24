package com.example.mynotes.new_note

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.mynotes.R

class NewNoteActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_new_note)

        val editNote = findViewById<EditText>(R.id.edit_note)

        val buttonCancel = findViewById<Button>(R.id.button_cancel)
        buttonCancel?.setOnClickListener {
            Log.d("NewNoteActivity",  "Button Cancel Clicked!")

            setResult(0)
            finish()
        }

        val buttonConfirm = findViewById<Button>(R.id.button_confirm)
        buttonConfirm?.setOnClickListener {
            Log.d("NewNoteActivity", "Button Confirm Clicked!")

            setResult(1, Intent().putExtra("EDIT_NOTE_CONTENT", editNote?.text.toString()))
            finish()
        }
    }
}