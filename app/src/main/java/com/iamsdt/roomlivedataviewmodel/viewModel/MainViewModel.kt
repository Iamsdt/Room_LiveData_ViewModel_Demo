package com.iamsdt.roomlivedataviewmodel.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.iamsdt.roomlivedataviewmodel.database.MyDatabase
import com.iamsdt.roomlivedataviewmodel.database.table.Book
import android.os.AsyncTask





/**
* Created by Shudipto Trafder Trafder on 11/16/2017.
*/

class MainViewModel(application: Application):
        AndroidViewModel(application){

    var itemPositionList:LiveData<List<Book>> ?= null
    private var myDatabase:MyDatabase ?= null

    init {
        myDatabase = MyDatabase.getDatabase(application.applicationContext)
        itemPositionList = myDatabase!!.bookDao.getAllData
    }

    fun deleteItem(book: Book) {
        DeleteAsyncTask(myDatabase!!).execute(book)
    }

    private class DeleteAsyncTask (private val db: MyDatabase) :
            AsyncTask<Book, Void, Void>() {

        override fun doInBackground(vararg params: Book): Void? {
            db.bookDao.delete(params[0])
            return null
        }
    }

}