package com.westley.filmscout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val film = intent.getParcelableExtra<Film>("Film")

        if (film != null) {
            val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
            val tvName: TextView = findViewById(R.id.tv_item_name)
            val tvDescription: TextView = findViewById(R.id.tv_item_description)
            val btnShare: Button = findViewById(R.id.action_share)

            // Use Glide to load the image
            Glide.with(this)
                .load(film.photo)
                .into(imgPhoto)

            tvName.text = film.name
            tvDescription.text = film.description

            btnShare.setOnClickListener {
                shareFilmInfo(film)
            }
        }
    }

    private fun shareFilmInfo(film: Film) {
        val shareText = "Check out this film: ${film.name}\n\n${film.description}"
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share film info via:"))
    }
}
