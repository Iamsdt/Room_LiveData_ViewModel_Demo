package com.iamsdt.roomlivedataviewmodel

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.DatePicker
import android.widget.Toast
import com.iamsdt.roomlivedataviewmodel.database.table.Book
import com.iamsdt.roomlivedataviewmodel.viewModel.AddViewModel
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.util.*

class AddActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener {

    private var date: Date? = null
    private var calendar: Calendar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(add_toolbar)

        calendar = Calendar.getInstance()
        val addViewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)

        //date picker dialog
        val datePickerDialog = DatePickerDialog(this,this,calendar!!.get(Calendar.YEAR),
                calendar!!.get(Calendar.MONTH), calendar!!.get(Calendar.DAY_OF_MONTH))

        button.setOnClickListener {
            datePickerDialog.show()
        }


        add_fab.setOnClickListener {

            val book = bookName.text.toString()
            val person = personName.text.toString()

            if (book.isEmpty() ||  person.isEmpty()
                    || date == null){
                Toast.makeText(this,"Missing Fields",Toast.LENGTH_SHORT).show()
            } else {
                addViewModel.addBook(Book(bookName = book,
                        personName = person,
                        date = date!!))

                finish()
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar!!.set(Calendar.YEAR, year)
        calendar!!.set(Calendar.MONTH, month)
        calendar!!.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        date = calendar!!.time

        dateTv.text = date.toString()
    }

}
