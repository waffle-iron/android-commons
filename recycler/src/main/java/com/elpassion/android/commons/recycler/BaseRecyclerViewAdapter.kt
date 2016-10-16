package com.elpassion.android.commons.recycler

open class BaseRecyclerViewAdapter : GenericRecyclerViewAdapter<ItemAdapter<*>>{
    constructor() : super()

    constructor(immutableList: List<ItemAdapter<*>>) : super(immutableList)
}
