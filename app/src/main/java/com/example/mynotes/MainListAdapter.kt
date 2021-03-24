package com.example.mynotes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.models.Note
import org.w3c.dom.Node

class MainListAdapter(
    val listNotes: ArrayList<String>
) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textNote : TextView = view.findViewById(R.id.text_item_note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textNote.text = listNotes[position]
    }

    override fun getItemCount() = listNotes.size

    fun addNote(note: String) {
        Log.d("MainListAdapter", "addNote $note")

        listNotes.add(note)

        Log.d("MainListAdapter", "$listNotes")
    }
}