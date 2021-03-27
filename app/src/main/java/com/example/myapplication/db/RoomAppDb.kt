package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.ArticlesItem

@Database(entities = [UserEntity::class, ArticlesItem::class, FavouriteEntity::class], version = 2)
abstract class RoomAppDb: RoomDatabase() {


    abstract fun DAO(): DAO?

    companion object {
        private var INSTANCE: RoomAppDb?= null

        fun getAppDatabase(context: Context): RoomAppDb? {

            if(INSTANCE == null ) {

                INSTANCE = Room.databaseBuilder<RoomAppDb>(
                    context.applicationContext, RoomAppDb::class.java, "AppDBB"
                )
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}