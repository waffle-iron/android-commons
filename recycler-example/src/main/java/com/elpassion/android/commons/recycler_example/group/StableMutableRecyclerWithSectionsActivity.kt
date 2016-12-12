package com.elpassion.android.commons.recycler_example.group

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.elpassion.android.commons.recycler.adapters.stableSectionedRecyclerViewAdapter
import com.elpassion.android.commons.recycler.components.group.impl.CachedMapItemsStrategy
import com.elpassion.android.commons.recycler.components.group.impl.MutableMapItemsStrategy
import com.elpassion.android.commons.recycler_example.R
import com.elpassion.android.commons.recycler_example.common.StableUserItemAdapter
import com.elpassion.android.commons.recycler_example.common.User
import com.elpassion.android.commons.recycler_example.common.createManyUsers
import com.elpassion.android.commons.recycler_example.common.createUsersWithASection
import kotlinx.android.synthetic.main.recycler_view_with_action.*

class StableMutableRecyclerWithSectionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_with_action)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val users = createManyUsers()
        val adapters = users.groupBy(User::organization).mapValues { it.value.map(::StableUserItemAdapter) }
        val itemsStrategy = CachedMapItemsStrategy(MutableMapItemsStrategy(adapters))
        val adapterCompositor = stableSectionedRecyclerViewAdapter(itemsStrategy)
        recyclerView.adapter = adapterCompositor

        clearSectionButton.setOnClickListener {
            itemsStrategy.set("A", emptyList())
            adapterCompositor.notifyDataSetChanged()
            restoreSectionButton.isEnabled = true
            clearSectionButton.isEnabled = false
        }
        restoreSectionButton.setOnClickListener {
            itemsStrategy.addAll("A", createUsersWithASection().map(::StableUserItemAdapter))
            adapterCompositor.notifyDataSetChanged()
            restoreSectionButton.isEnabled = false
            clearSectionButton.isEnabled = true
        }
    }
}