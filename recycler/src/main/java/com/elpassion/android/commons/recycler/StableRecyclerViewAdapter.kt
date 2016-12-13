package com.elpassion.android.commons.recycler

open class StableRecyclerViewAdapter : GenericRecyclerViewAdapter<StableItemAdapter<*>> {

    constructor() : super()

    constructor(immutableList: List<StableItemAdapter<*>>) : super(immutableList)

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = adapters[position].stableId
}