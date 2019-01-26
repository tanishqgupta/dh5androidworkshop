package com.example.dh5workshop

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HomeActivityAdapter(private val data: List<String>): RecyclerView.Adapter<HomeActivityAdapter.ViewHolder>() {


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HomeActivityAdapter.ViewHolder, position: Int) {
        holder.value.setText(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeActivityAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.recycler_cell, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val value: TextView = view.findViewById(R.id.cell_text)
    }
}
