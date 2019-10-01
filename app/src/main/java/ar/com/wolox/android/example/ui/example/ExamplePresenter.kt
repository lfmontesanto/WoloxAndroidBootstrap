package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.example.model.ModelOrder
import ar.com.wolox.android.example.network.GraphQlService
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.wolox.queries.GetOrdersQuery

import javax.inject.Inject

class ExamplePresenter @Inject constructor(private val mUserSession: UserSession) : BasePresenter<IExampleView>() {

    private lateinit var orderList: ArrayList<ModelOrder>

    fun onLoginButtonClicked(text: String) {
        mUserSession.username = text
        view.goToViewPager()
    }

    fun getOrders(page: Int, limit: Int) {
        val graphQlService = GraphQlService().getOrders(page, limit).enqueue(object : ApolloCall.Callback<GetOrdersQuery.Data>() {
            override fun onFailure(e: ApolloException) {
                // view on error
            }

            override fun onResponse(response: Response<GetOrdersQuery.Data>) {
                orderList = ArrayList()
                response.data()?.orders()?.orders()?.forEach {
                    this@ExamplePresenter.orderList.add(ModelOrder.fromGraphQl(it))
                }
            }
        })
    }
}
