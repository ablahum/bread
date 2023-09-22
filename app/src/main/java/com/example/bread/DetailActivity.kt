package com.example.bread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.bread.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_IMG = "extra_img"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setContentView(binding.root)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDesc: TextView = findViewById(R.id.tv_desc)
        val tvImg: ImageView = findViewById(R.id.tv_img)

        val name = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val img = intent.getIntExtra(EXTRA_IMG, 0)

        tvName.text = name
        tvDesc.text = desc
        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(tvImg)
    }
}