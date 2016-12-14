package com.elpassion.android.commons.recycler_example.group

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.elpassion.android.commons.recycler.RecyclerViewCompositeAdapter
import com.elpassion.android.commons.recycler.components.group.impl.MapItemsStrategy
import com.elpassion.android.commons.recycler_example.R
import com.elpassion.android.commons.recycler_example.common.SimpleUserItemAdapter
import com.elpassion.android.commons.recycler_example.common.User
import com.elpassion.android.commons.recycler_example.common.createManyUsers
import kotlinx.android.synthetic.main.recycler_view.*

class RecyclerWithSectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val users = createManyUsers()
        val adapters = users.groupBy(User::organization).mapValues { it.value.map(::SimpleUserItemAdapter) }
        val itemsStrategy = MapItemsStrategy(adapters)
        recyclerView.adapter = RecyclerViewCompositeAdapter(itemsStrategy = itemsStrategy)

        Log.i(RecyclerWithSectionActivity::class.java.name, itemsStrategy.getSection("A").size.toString())
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, RecyclerWithSectionActivity::class.java))
        }

        const val DESCRIPTION = "Recycler with sections"
    }
}