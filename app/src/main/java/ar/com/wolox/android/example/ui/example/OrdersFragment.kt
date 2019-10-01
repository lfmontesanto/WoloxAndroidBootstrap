package ar.com.wolox.android.example.ui.example

import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class OrdersFragment : WolmoFragment<OrdersPresenter>(), OrdersView {

    private lateinit var adapter: RecyclerView.Adapter
    override fun init() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun layout(): Int = R.layout.fragment_orders
}