package com.mws.formregistrasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvData = findViewById<TextView>(R.id.tv_data_second_activity)

        val hasil = intent.getStringExtra("KEY_HASIL")

        tvData.text = hasil
    }
}