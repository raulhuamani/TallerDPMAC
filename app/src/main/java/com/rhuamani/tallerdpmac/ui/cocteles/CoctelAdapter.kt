package com.rhuamani.tallerdpmac.ui.cocteles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rhuamani.tallerdpmac.R

class CoctelAdapter(private val coctelList: List<CoctelModel>): RecyclerView.Adapter<CoctelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_coctel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nombreCoctel = coctelList[position].nombre
        val urlCoctel = coctelList[position].url
        val idCoctel = coctelList[position].id

        holder.txtNombreCoctel.text = nombreCoctel

        Glide.with(holder.itemView.context)
            .load(urlCoctel)
            .centerCrop()
            .placeholder(R.drawable.wine_bar)
            .into(holder.imgCoctel)
    }

    override fun getItemCount(): Int {
        return coctelList.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgCoctel: ImageView = view.findViewById(R.id.imgCoctel)
        val txtNombreCoctel: TextView = view.findViewById(R.id.txtNombreCoctel)
    }

}