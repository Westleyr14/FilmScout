package com.westley.filmscout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imgPhoto: ImageView = findViewById(R.id.img_my_photo)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvEmail: TextView = findViewById(R.id.tv_email)
        val tvAppAbout: TextView = findViewById(R.id.tv_app_about)

        imgPhoto.setImageResource(R.drawable.foto_westley)
        tvName.text = "Westley Randanan Situmorang"
        tvEmail.text = "westleyr14@gmail.com"
    }
}
