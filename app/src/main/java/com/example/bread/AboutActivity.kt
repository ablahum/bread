package com.example.bread

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_IMG = "extra_img"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val tvName: TextView = findViewById(R.id.tv_about_name)
        val tvEmail: TextView = findViewById(R.id.tv_about_email)
        val tvImg: ImageView = findViewById(R.id.tv_about_img)

        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val img = intent.getIntExtra(EXTRA_IMG, 0)

        tvName.text = name
        tvEmail.text = email
        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(tvImg)
    }
}