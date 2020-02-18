package com.example.androidlabone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class ViewToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_to_do)

        val theTitle = findViewById<TextView>(R.id.viewTitle)
        val theContent = this.findViewById<TextView>(R.id.viewContent)

        val theId = intent.getIntExtra("id",10)

        val todo = toDoRepository.getToDoById(theId)!!

        theTitle.text = todo.title
        theContent.text = todo.content

        val viewUpdateBtn = findViewById<Button>(R.id.viewUpdateBtn)
        val viewDeleteBtn = findViewById<Button>(R.id.viewDeleteBtn)

        viewDeleteBtn.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(
                    R.string.dialog_positive
                ) { dialog, whichButton ->
                    // Delete it.
                    toDoRepository.deleteToDoById(theId)
                    val intent = Intent(this,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                }.setNegativeButton(
                    R.string.dialog_negative
                ) { dialog, whichButton ->
                    // Do not delete it.
                    val intent = Intent(this,UpdateToDoActivity::class.java)
                    intent.putExtra("id",theId)
                    finish()
                    startActivity(intent)
                }.show()
        }

        viewUpdateBtn.setOnClickListener{
            val intent = Intent(this,UpdateToDoActivity::class.java)
            intent.putExtra("id",theId)
            finish()
            startActivity(intent)
        }

       /* val content = this.findViewById<EditText>(
            R.id.enterContentOnCreate
        ).editableText.toString()
*/

    }
}
