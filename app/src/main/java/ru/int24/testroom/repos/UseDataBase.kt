package ru.int24.testroom.repos

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.int24.testroom.interfaces.DocumentDao

abstract class UseDataBase: RoomDatabase() {

    abstract fun documentDao(): DocumentDao

    companion object {
        @Volatile
        private var INSTANCE: UseDataBase? = null

        fun getInstance(context: Context): UseDataBase{

            val templInstance = INSTANCE

            if (templInstance != null) return templInstance

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, UseDataBase::class.java, "use_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}