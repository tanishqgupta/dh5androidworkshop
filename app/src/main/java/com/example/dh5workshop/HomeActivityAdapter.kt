package com.example.dh5workshop

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HomeActivityAdapter(private val data: Map<String, Cryptocurrency>): RecyclerView.Adapter<HomeActivityAdapter.ViewHolder>() {

    private lateinit var keys: List<String>

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HomeActivityAdapter.ViewHolder, position: Int) {
        holder.currencyName.text = keys[position]

        val key = keys[position]
        holder.price.text = data.get(key)!!.rate.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeActivityAdapter.ViewHolder {
        keys = data.keys.toList()
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.recycler_cell, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val currencyName: TextView = view.findViewById(R.id.cell_text)
        val price: TextView = view.findViewById(R.id.pricelabel)
    }
}
