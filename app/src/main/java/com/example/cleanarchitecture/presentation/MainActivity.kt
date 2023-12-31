package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.R

class MainActivity : AppCompatActivity() {


    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")
        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val receiveButton = findViewById<Button>(R.id.receiveButton)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)

        vm.resultLive.observe(this, { text ->
            dataTextView.text = text
        })


        sendButton.setOnClickListener {
            val text: String = dataEditText.text.toString()
            vm.save(text)
        }

        receiveButton.setOnClickListener {
            vm.load()
        }
    }
}