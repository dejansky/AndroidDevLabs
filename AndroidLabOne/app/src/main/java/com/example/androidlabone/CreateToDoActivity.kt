package com.example.androidlabone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_create_to_do.*
import kotlinx.android.synthetic.main.activity_update_to_do.*

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)



        val createBtn = findViewById<Button>(R.id.btnOnCreate)

        enterTitleOnCreate.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                createBtn.isEnabled = s.toString().trim() != ""
            }
        })

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
