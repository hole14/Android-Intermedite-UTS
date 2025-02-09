package com.example.myprojectuts.recycle

import android.content.Intent
import android.os.Parcelable
import android.provider.Telephony.Mms.Intents
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myprojectuts.R
import com.example.myprojectuts.deskripsi.DeskripsiStatus
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.parcelize.Parcelize

class AdapterClass(private val listAja: ArrayList<tampil>): RecyclerView.Adapter<AdapterClass.listViewHolder>() {
    private lateinit var pencet: onItemClickCallback

    interface onItemClickCallback{
        fun clickItem(data: tampil)
    }

    fun set(clickItem: onItemClickCallback){
        this.pencet = clickItem
    }

    companion object{
        private const val EXTRA_JUDUL = "extra_judul"
        private const val EXTRA_PHOTO = "extra_photo"
    }

    class listViewHolder(lihatItem: View): RecyclerView.ViewHolder(lihatItem) {
        val judul: TextView = lihatItem.findViewById(R.id.tx_judul)
        val photo: CircleImageView = lihatItem.findViewById(R.id.circleImageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        val tampil: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        return listViewHolder(tampil)
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
       val (judul, photo) = listAja[position]

        holder.judul.text = judul
        holder.photo.setImageResource(photo)

        holder.itemView.setOnClickListener{
            pencet.clickItem(listAja[holder.adapterPosition])
            val intent = Intent(holder.itemView.context, DeskripsiStatus::class.java)
            intent.putExtra(EXTRA_JUDUL, judul)
            intent.putExtra(EXTRA_PHOTO, photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listAja.size

}
@Parcelize
data class tampil(
    val judul: String,
    val photo: Int
):Parcelable