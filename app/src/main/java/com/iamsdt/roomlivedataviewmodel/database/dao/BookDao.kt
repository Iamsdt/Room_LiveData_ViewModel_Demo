package com.iamsdt.roomlivedataviewmodel.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.iamsdt.roomlivedataviewmodel.database.table.Book

/**
* Created by Shudipto Trafder Trafder on 11/16/2017.
*/
//Data accessing object
@Dao
interface BookDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: Book):Long

    //their is two option for get all data from table
    //one is by using member variable
    @get:Query("Select * From Book")
    val getAllData:LiveData<List<Book>>

    //and another is like as usual function
    @Query("Select * From Book")
    fun getData():LiveData<List<Book>>


//    //for single data
//    @Query("Select * From Book where id = :_id")
//    fun getBorrowById(_id:Int):Book


    @Delete
    fun delete(book:Book):Int

    @Update
    fun update(book: Book):Int

}