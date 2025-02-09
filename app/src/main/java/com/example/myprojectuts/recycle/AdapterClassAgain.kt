package com.example.myprojectuts.recycle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myprojectuts.R
import de.hdodenhof.circleimageview.CircleImageView

class AdapterClassAgain(private val listAjaLagi: ArrayList<tampilanLagi>): RecyclerView.Adapter<AdapterClassAgain.listViewHolder>() {

    private lateinit var klik: onItemClickCallback

    interface onItemClickCallback{
        fun clickItem(data: tampilanLagi)
    }

    class listViewHolder(lihatAja: View): RecyclerView.ViewHolder(lihatAja) {
        val judul: TextView = lihatAja.findViewById(R.id.judul_lagi)
        val photo: CircleImageView = lihatAja.findViewById(R.id.circleImageView3)
        val poto: ImageView = lihatAja.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        val penampilan: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_2, parent, false)
        return listViewHolder(penampilan)
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val (judul, photo, poto) = listAjaLagi[position]

        holder.judul.text = judul
        holder.photo.setImageResource(photo)
        holder.poto.setImageResource(poto)
    }

    override fun getItemCount(): Int = listAjaLagi.size

}
data class tampilanLagi(
    val judul: String,
    val photo: Int,
    val poto: Int
)
