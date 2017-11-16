package com.iamsdt.roomlivedataviewmodel.database.table

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.iamsdt.roomlivedataviewmodel.database.DateConverter
import java.util.*


/**
* Created by Shudipto Trafder Trafder on 11/16/2017.
*/

//Entity will crate table name with class name
// but option to modify table name
//@Entity(tableName = "TableName")

@Entity
class Book() {

    @PrimaryKey (autoGenerate = true)
    var id:Int ?= null

    var bookName:String ?= null
    var personName:String ?= null

    @TypeConverters(DateConverter::class)
    var date:Date ?= null

    constructor (bookName: String?, personName: String?, date: Date?):this() {
        this.bookName = bookName
        this.personName = personName
        this.date = date
    }
}