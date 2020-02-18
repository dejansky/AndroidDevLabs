package com.example.androidlabone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_update_to_do.*

class UpdateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_to_do)

        val theTitle = findViewById<TextView>(R.id.newTitle)
        val theContent = this.findViewById<TextView>(R.id.newContent)

        val theId = intent.getIntExtra("id",-1)

        val todo = toDoRepository.getToDoById(theId)!!

        theTitle.text = todo.title
        theContent.text = todo.content

        val saveBtn = findViewById<Button>(R.id.saveBtn)

        newTitle.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s.toString().trim() != ""
            }
        })

        saveBtn.setOnClickListener{

            val newTitle = findViewById<EditText>(
                R.id.newTitle
            ).editableText.toString()

            val newContent = this.findViewById<EditText>(
                R.id.newContent
            ).editableText.toString()

            toDoRepository.updateToDoById(theId,newTitle,newContent)

            finish()
        }
    }
}
