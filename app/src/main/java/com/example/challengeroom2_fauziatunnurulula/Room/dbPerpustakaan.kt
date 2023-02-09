package com.example.challengeroom2_fauziatunnurulula.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (
   entities = [TbBuku::class],
    version = 1
)
abstract class dbPerpustakaan : RoomDatabase(){
    abstract  fun  TbBukuDao() : TbBukuDao

    companion object{
        @Volatile private  var instance : dbPerpustakaan? = null
        private  val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
context.applicationContext,
            dbPerpustakaan::class.java,
            "tbsiswa12345.db"
        ).build()
    }
}

