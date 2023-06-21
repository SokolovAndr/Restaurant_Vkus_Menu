package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)


        var tvTitle = findViewById<TextView>(R.id.tvTitlePOVTOR)
        tvTitle.text = intent.getStringExtra("title")

        var tvContent = findViewById<TextView>(R.id.textView3)
        tvContent.text = intent.getStringExtra("content")

        var im = findViewById<ImageView>(R.id.imPOVTOR)
        im.setImageResource(intent.getIntExtra("image", R.drawable.ic_history))

    }

    fun toastMe (view: View){
        Toast.makeText(this, "Товар успешно добавлен в корзину", Toast.LENGTH_SHORT).show()
    }
}