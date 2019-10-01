package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.example.model.ModelOrder
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class OrdersPresenter @Inject constructor(private val orderList: List<ModelOrder>) : BasePresenter<OrdersView>()