package com.example.androidlabone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.EditText

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)



        val createBtn = findViewById<Button>(R.id.btnOnCreate) as Button
        createBtn.setOnClickListener {
            val title = findViewById<EditText>(
                R.id.enterTitleOnCreate
            ).editableText.toString()

            val content = this.findViewById<EditText>(
                R.id.enterContentOnCreate
            ).editableText.toString()

            toDoRepository.addToDo(title,content);
            finish()
        }



    }
}
