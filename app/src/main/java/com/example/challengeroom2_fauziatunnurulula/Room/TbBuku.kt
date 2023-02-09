package com.example.challengeroom2_fauziatunnurulula.Room

import androidx.room.Entity

@Entity
class TbBuku (
    val id_buku : Int,
    val kategori : String,
    val judul : String,
    val pengarang : String,
    val penerbit : String,
    val jumlah_buku : String
        )
