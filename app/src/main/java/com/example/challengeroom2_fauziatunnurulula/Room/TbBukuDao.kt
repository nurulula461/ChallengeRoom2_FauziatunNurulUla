package com.example.challengeroom2_fauziatunnurulula.Room

import androidx.room.*


@Dao
interface TbBukuDao {
    @Insert
    fun addBuku (tbBuku: TbBuku)

    @Update
    fun updateBuku (tbBuku: TbBuku)

    @Delete
    fun deleteBuku (tbBuku: TbBuku)

    @Query("SELECT * FROM tbbuku")
    fun  dataBuku (): List<TbBuku>
}