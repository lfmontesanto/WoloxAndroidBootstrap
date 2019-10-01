package ar.com.wolox.android.example.ui.example

import android.util.Log
import ar.com.wolox.android.example.model.ModelOrder
import ar.com.wolox.android.example.network.GraphQlService
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.wolox.queries.GetOrdersQuery
import javax.inject.Inject

class OrdersPresenter @Inject constructor() : BasePresenter<OrdersView>() {
    private var orderList: ArrayList<ModelOrder>? = null

    fun init() {
        orderList = ArrayList()
        view.toggleProgress(true)
        getOrders(1, 10)
    }

    private fun getOrders(page: Int, limit: Int) {
        GraphQlService.getInstance().getOrders(page, limit).enqueue(object : ApolloCall.Callback<GetOrdersQuery.Data>() {
            override fun onFailure(e: ApolloException) {
                Log.v("ERROR---", e.toString())
            }

            override fun onResponse(response: Response<GetOrdersQuery.Data>) {
                response.data()?.orders()?.orders()?.forEach {
                    Log.v("ok---", it.id())
                    this@OrdersPresenter.orderList?.add(ModelOrder.fromGraphQl(it))
                    view.onOrdersLoaded(orderList!!)
                }
            }
        })
    }
}