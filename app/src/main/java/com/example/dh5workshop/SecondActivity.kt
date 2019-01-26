package com.example.dh5workshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Setup Recycler View Components

        linearLayoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        this.recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = HomeActivityAdapter( listOf("abc", "123", "def", "456") )
    }
}
