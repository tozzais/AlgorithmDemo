package com.example.algorithmdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val `is` = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    inner class MyClass : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (`is`) {
            }
        }
    }
}