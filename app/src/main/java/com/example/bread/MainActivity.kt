package com.example.bread

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvLists: RecyclerView
    private var list: ArrayList<Bread> = arrayListOf()
    private lateinit var btnMove: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMove = findViewById(R.id.btn_about)
        btnMove.setOnClickListener(this)

        rvLists = findViewById(R.id.rv_lists)
        rvLists.setHasFixedSize(true)

        list.addAll(BreadData.listData)
        rvLists.layoutManager = LinearLayoutManager(this)

        val listAdapter = ListBelajarAdapter(list)
        rvLists.adapter = listAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_about -> {
                val person = Person(
                    "Muhammad Rizky Pratama",
                    "mriztama@gmail.com",
                    R.drawable.me
                )

                val items = Intent(this@MainActivity, AboutActivity::class.java)

                items.putExtra(AboutActivity.EXTRA_NAME, person.name)
                items.putExtra(AboutActivity.EXTRA_EMAIL, person.email)
                items.putExtra(AboutActivity.EXTRA_IMG, person.img)

                startActivity(items)
            }
        }
    }
}