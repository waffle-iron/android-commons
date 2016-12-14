package com.elpassion.android.commons.recycler_example.group

import android.support.v7.app.AppCompatActivity
import com.elpassion.android.commons.recycler.RecyclerViewCompositeAdapter
import com.elpassion.android.commons.recycler.components.group.impl.CachedMapItemsStrategy
import com.elpassion.android.commons.recycler.components.group.impl.MutableMapItemsStrategy
import com.elpassion.android.commons.recycler_example.R
import com.elpassion.android.commons.recycler_example.common.*
import kotlinx.android.synthetic.main.recycler_view_with_action.*

class MutableRecyclerWithSectionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_with_action)
        recyclerView.layoutManager = android.support.v7.widget.LinearLayoutManager(this)
        val users = createManyUsers()
        val adapters = users.groupBy(User::organization).mapValues {
            it.value.map { user ->
                if (user.organization == "A") SimpleUserItemAdapter(user)
                else OtherSimpleUserItemAdapter(user)
            }
        }
        val itemsStrategy = CachedMapItemsStrategy(MutableMapItemsStrategy(adapters))
        val adapterCompositor = RecyclerViewCompositeAdapter(itemsStrategy = itemsStrategy)
        recyclerView.adapter = adapterCompositor

        clearSectionButton.setOnClickListener {
            itemsStrategy.set("A", emptyList())
            adapterCompositor.notifyDataSetChanged()
            restoreSectionButton.isEnabled = true
            clearSectionButton.isEnabled = false
        }
        restoreSectionButton.setOnClickListener {
            itemsStrategy.addAll("A", createUsersWithASection().map(::SimpleUserItemAdapter))
            adapterCompositor.notifyDataSetChanged()
            restoreSectionButton.isEnabled = false
            clearSectionButton.isEnabled = true
        }
    }
}

