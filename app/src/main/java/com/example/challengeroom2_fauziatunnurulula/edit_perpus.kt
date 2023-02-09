package com.example.challengeroom2_fauziatunnurulula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeroom2_fauziatunnurulula.Room.TbBuku
import com.example.challengeroom2_fauziatunnurulula.Room.dbPerpustakaan
import kotlinx.android.synthetic.main.edit_perpus.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class edit_perpus : AppCompatActivity() {
    val db by lazy {dbPerpustakaan(this)}

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.edit_perpus)
            simpanperpus()
        }
        fun simpanperpus(){
            bt_simpan.setOnClickListener{
                CoroutineScope(Dispatchers.IO).launch {
                    db.TbBukuDao().addBuku(
                        TbBuku(et_id.text.toString().toInt(),et_katgor.text.toString(),et_judul.text.toString(),et_jumlah.text.toString(),
                        et_pengarang.text.toString(),et_penerbit.text.toString())
                    )
                    finish()
                }
            }
        }
}
