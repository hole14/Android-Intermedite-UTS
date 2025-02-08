package com.example.myprojectuts

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myprojectuts.databinding.ActivityMainBinding
import com.example.myprojectuts.recycle.AdapterClass
import com.example.myprojectuts.recycle.tampil

class MainActivity : AppCompatActivity() {
    private lateinit var tampil: RecyclerView
    private val list = ArrayList<tampil>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tampil = findViewById(R.id.recycler_view)
        tampil.setHasFixedSize(true)

        list.addAll(listTampilan())
        daftarTampilan()
    }

    private fun listTampilan(): ArrayList<tampil> {
        val dataJudul = resources.getStringArray(R.array.data_username)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTampil = ArrayList<tampil>()
        for(i in dataJudul.indices){
            val tampil = tampil(dataJudul[i], dataPhoto.getResourceId(i, -1))
            listTampil.add(tampil)
        }
        return listTampil
    }

    private fun daftarTampilan(){
        tampil.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = AdapterClass(list)
        tampil.adapter = adapter
    }
}