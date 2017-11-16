package com.iamsdt.roomlivedataviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.iamsdt.roomlivedataviewmodel.adapter.MainAdapter
import com.iamsdt.roomlivedataviewmodel.database.table.Book
import com.iamsdt.roomlivedataviewmodel.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(),View.OnLongClickListener {

    private var viewModel:MainViewModel ?= null
    private var adapter:MainAdapter ?= null
    private val emptyList:List<Book> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(emptyList,this)

        val manager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false)

        fab.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }

        mainRcv.layoutManager = manager
        mainRcv.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        viewModel!!.itemPositionList!!.observe(this, object :Observer <List<Book>>{
//            override fun onChanged(@Nullable itemAndPeople: List<Book>?) {
//                adapter!!.replaceList(itemAndPeople)
//            }
//        })

        //lambda convert by android studio
        viewModel!!.itemPositionList!!
                .observe(this,
                        Observer<List<Book>> { itemAndPeople ->
                            adapter!!.replaceList(itemAndPeople) })
    }

    override fun onLongClick(v: View?): Boolean {
        val book = v!!.tag as Book
        viewModel!!.deleteItem(book)
        return true
    }
}
