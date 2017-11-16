package com.iamsdt.roomlivedataviewmodel.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.AsyncTask
import com.iamsdt.roomlivedataviewmodel.database.MyDatabase
import com.iamsdt.roomlivedataviewmodel.database.table.Book

/**
* Created by Shudipto Trafder Trafder on 11/16/2017.
*/

class AddViewModel(application: Application):
        AndroidViewModel(application){

    private var myDatabase:MyDatabase ?= null

    init {
        myDatabase = MyDatabase.getDatabase(context = application)
    }

    fun addBook(book: Book){
        AddBook(myDatabase!!).execute(book)
    }

    private class AddBook(private val database: MyDatabase):AsyncTask<Book,Void,Void>(){

        override fun doInBackground(vararg params: Book?): Void? {
            database.bookDao.insert(params[0]!!)
            return null
        }

    }

}