package com.iamsdt.roomlivedataviewmodel.database

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
* Created by Shudipto Trafder Trafder on 11/16/2017.
*/
class DateConverter {

    //This class is for convert date to long
    //by default SQL is not support date
    //so when sql store date, it's convert by date to long
    //when I access the vale of date column I don't need long value
    //I put the value in date

    @TypeConverter
    fun toDate(date: Long):Date = Date(date)

    @TypeConverter
    fun toLong(date: Date):Long = date.time

}