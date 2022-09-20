package com.example.gdroom_d_10554.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDB2: RoomDatabase() {
    abstract fun noteDao2() : NoteDao
    companion object {
        @Volatile private var instance : NoteDB2? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDB2::class.java,
                "note10554.db"
            ).build()
    }

}