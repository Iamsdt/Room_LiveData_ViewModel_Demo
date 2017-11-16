package com.iamsdt.roomlivedataviewmodel.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iamsdt.roomlivedataviewmodel.R
import com.iamsdt.roomlivedataviewmodel.database.table.Book
import kotlinx.android.synthetic.main.item_row.view.*

/**
* Created by Shudipto Trafder Trafder on 11/16/2017.
*/

class MainAdapter(private var list: List<Book>?,
                  private val longClickListener: View.OnLongClickListener):
        RecyclerView.Adapter<MainAdapter.MyViewHolder>() {


    override fun getItemCount(): Int = list ?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.item_row,parent,false)

        return MyViewHolder(view)
    }

    fun replaceList(list: List<Book>?){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val book = list!![position]

        holder!!.itemView.personName.text = book.personName
        holder.itemView.bookName.text = book.bookName

        //now just convert date to simple string
        //latter change the date with simple date format
        holder.itemView.date.text = book.date.toString()

        holder.itemView.tag = book

        //long click listener for edit item
        holder.itemView.setOnLongClickListener(longClickListener)
    }


    inner class MyViewHolder(view: View):
            RecyclerView.ViewHolder(view){
        val bookName = view.bookName
        val personName = view.personName
        val date = view.date
    }

}