package com.example.myprojectuts.deskripsi

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprojectuts.R
import com.example.myprojectuts.recycle.AdapterClass
import de.hdodenhof.circleimageview.CircleImageView

class DeskripsiStatus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deskripsi_status)

        val judul = intent.getStringExtra(AdapterClass.EXTRA_JUDUL)
        val photo = intent.getIntExtra(AdapterClass.EXTRA_PHOTO, 0)

        val user: TextView = findViewById(R.id.textView)
        val profile: CircleImageView = findViewById(R.id.circleImageView2)
        val status: ImageView = findViewById(R.id.imageView)

        user.text = judul
        profile.setImageResource(photo)
        status.setImageResource(photo)

        val share: ImageView = findViewById(R.id.share)

        share.setOnClickListener{
            val bagikan = Intent(Intent.ACTION_SEND)
            bagikan.putExtra(Intent.EXTRA_TEXT, "Saya sedang melihat $judul")
            bagikan.type = "text/plain"
            startActivity(Intent.createChooser(bagikan, "Bagikan"))
        }

        val like: ImageView = findViewById(R.id.like)
        var ini = false

        like.setOnClickListener{
            ini = !ini
            like.isSelected = ini
        }
    }
}