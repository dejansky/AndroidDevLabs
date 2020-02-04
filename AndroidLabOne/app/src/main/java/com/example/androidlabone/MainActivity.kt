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

    lateinit var adapter:ArrayAdapter<ToDo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = this.findViewById<ListView>(R.id.mainListView)
        adapter = ArrayAdapter<ToDo>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            toDoRepository.getAllToDos()
        )

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this,ViewToDoActivity::class.java);

            val passToDo = parent.getItemAtPosition(position) as ToDo
            intent.putExtra("id", passToDo.id)
            startActivity(intent)
        }

        val createBtn = findViewById<Button>(R.id.btnOnMain) as Button
        createBtn.setOnClickListener {
            val intent = Intent(this,CreateToDoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.notifyDataSetChanged()

    }

}
