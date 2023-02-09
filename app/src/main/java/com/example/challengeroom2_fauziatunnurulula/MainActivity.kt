package com.example.challengeroom2_fauziatunnurulula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.challengeroom2_fauziatunnurulula.Room.dbPerpustakaan
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val db by lazy { dbPerpustakaan(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pindahperpus()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch{
            val perpus = db.TbBukuDao().dataBuku()
            Log.d("MainAcivity","dbResponce : $perpus")
        }
    }
    fun pindahperpus(){
        btn_rvPerpus.setOnClickListener{
            startActivity(Intent(this,edit_perpus::class.java))

        }

    }
}