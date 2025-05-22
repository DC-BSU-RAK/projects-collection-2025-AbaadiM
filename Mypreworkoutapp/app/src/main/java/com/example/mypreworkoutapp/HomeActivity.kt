package com.example.mypreworkoutapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun openProduct1(view: View) {
        startActivity(Intent(this, Product1Activity::class.java))
    }

    fun openProduct2(view: View) {
        startActivity(Intent(this, Product2Activity::class.java))
    }

    fun openProduct3(view: View) {
        startActivity(Intent(this, Product3Activity::class.java))
    }

    fun openProduct4(view: View) {
        startActivity(Intent(this, Product4Activity::class.java))
    }

    fun openProduct5(view: View) {
        startActivity(Intent(this, Product5Activity::class.java))
    }
}
