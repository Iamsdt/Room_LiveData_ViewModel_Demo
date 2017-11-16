package com.iamsdt.roomlivedataviewmodel.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.iamsdt.roomlivedataviewmodel.database.dao.BookDao
import com.iamsdt.roomlivedataviewmodel.database.table.Book

/**
* Created by Shudipto Trafder Trafder on 11/16/2017.
*/

//this class must be abstract
@Database(entities = arrayOf(Book::class),version = 1,
        //don't export database
        exportSchema = false)
abstract class MyDatabase:RoomDatabase(){


    abstract val bookDao:BookDao

    companion object {

        private var instance:MyDatabase ?= null
        private val dbName = "BookDB"

        fun getDatabase(context: Context):MyDatabase{

            if (instance == null) {
                instance = Room.databaseBuilder(context,
                        MyDatabase::class.java,dbName).build()
            }

            return instance!!
        }
    }

}