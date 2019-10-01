package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.example.model.ModelOrder

interface OrdersView {

    fun onOrdersLoaded(orders: List<ModelOrder>)

    fun onError()

    fun toggleProgress(toggle: Boolean)
}