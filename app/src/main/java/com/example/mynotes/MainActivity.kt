package com.example.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.new_note.NewNoteActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val adapter : MainListAdapter =
        MainListAdapter(arrayListOf<String>("Lorem Ipsum", "Funciona", "Pois é"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNewNote = findViewById<Button>(R.id.button_add_note)

        buttonNewNote?.setOnClickListener {
            Log.d("MainActivity", "Button New Note Clicked!")

            val intent = Intent(this, NewNoteActivity::class.java)
            startActivityForResult(intent, MainViewModel.NEW_NOTE_REQUEST_CODE)
            
        }

        val list_notes = findViewById<RecyclerView>(R.id.list_notes)
        list_notes?.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            MainViewModel.NEW_NOTE_REQUEST_CODE -> {
                Log.d("MainActivity", "ActivityResult : $resultCode")

                val edit_note : String? = data?.getStringExtra("EDIT_NOTE_CONTENT")
                Log.d("MainActivity", "getStringExtra $edit_note")

                edit_note?.let {
                    adapter.addNote(it)
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}