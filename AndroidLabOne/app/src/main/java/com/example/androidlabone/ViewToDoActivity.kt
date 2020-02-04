package com.example.androidlabone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ViewToDoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TODO_ID = "TODO_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_to_do)

        val theTitleString = intent.getIntExtra("id",-1)

        val theTitle = findViewById<TextView>(R.id.viewTitle)


        val todo = toDoRepository.getToDoById(theTitleString)!!

        todo.title

       /* val content = this.findViewById<EditText>(
            R.id.enterContentOnCreate
        ).editableText.toString()
*/

    }
}
