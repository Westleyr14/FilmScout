package com.westley.filmscout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListFilmAdapter(private val listFilm: ArrayList<Film>) : RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_film, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val film = listFilm[position]

        holder.tvName.text = film.name
        holder.tvDescription.text = film.description
        Glide.with(holder.itemView.context)
            .load(film.photo)
            .into(holder.imgPhoto)

        // Set the click listener on each item
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listFilm[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Film)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
