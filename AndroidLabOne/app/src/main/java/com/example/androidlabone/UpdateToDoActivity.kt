package com.example.androidlabone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

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

        saveBtn.setOnClickListener{

            val newTitle = findViewById<EditText>(
                R.id.newTitle
            ).editableText.toString()

            val newContent = this.findViewById<EditText>(
                R.id.newContent
            ).editableText.toString()

            toDoRepository.updateToDoById(theId,newTitle,newContent)

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
