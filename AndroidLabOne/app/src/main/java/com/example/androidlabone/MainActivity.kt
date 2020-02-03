package com.example.androidlabone

import android.content.Context
import android.content.Intent
import android.content.LocusId
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = this.findViewById<ListView>(R.id.mainListView)

        listView.adapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            toDoRepository.getAllToDos()
        )

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                 val intent = Intent(this,ViewToDoActivity::class.java);
                 startActivity(intent)
        }

        val createBtn = findViewById<Button>(R.id.btnOnMain)
        createBtn.setOnClickListener {
            val intent = Intent(this,CreateToDoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()



    }

}
