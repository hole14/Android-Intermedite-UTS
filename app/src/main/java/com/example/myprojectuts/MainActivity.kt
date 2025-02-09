package com.example.myprojectuts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myprojectuts.recycle.AdapterClass
import com.example.myprojectuts.recycle.AdapterClassAgain
import com.example.myprojectuts.recycle.tampilan
import com.example.myprojectuts.recycle.tampilanLagi

class MainActivity : AppCompatActivity() {
    private lateinit var tampil: RecyclerView
    private lateinit var tampilLagi: RecyclerView
    private val list = ArrayList<tampilan>()
    private val listLagi = ArrayList<tampilanLagi>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tampilLagi = findViewById(R.id.recyclerView)
        tampilLagi.setHasFixedSize(true)

        tampil = findViewById(R.id.recycler_view)
        tampil.setHasFixedSize(true)

        list.addAll(listTampilan())
        daftarTampilan()

        listLagi.addAll(listAlis())
        daftarDah()
    }

    private fun listAlis(): ArrayList<tampilanLagi> {
        val dataJudul = resources.getStringArray(R.array.data_username)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPoto = resources.obtainTypedArray(R.array.data_photo)
        val listTampil = ArrayList<tampilanLagi>()
        for(i in dataJudul.indices){
            val tampil = tampilanLagi(dataJudul[i], dataPhoto.getResourceId(i, -1), dataPoto.getResourceId(i, -1))
            listTampil.add(tampil)
        }
        return listTampil
    }
    private fun daftarDah(){
        tampilLagi.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = AdapterClassAgain(listLagi)
        tampilLagi.adapter = adapter
    }

    private fun listTampilan(): ArrayList<tampilan> {
        val dataJudul = resources.getStringArray(R.array.data_username)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTampil = ArrayList<tampilan>()
        for(i in dataJudul.indices){
            val tampil = tampilan(dataJudul[i], dataPhoto.getResourceId(i, -1))
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