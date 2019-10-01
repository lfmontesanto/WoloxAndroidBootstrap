package ar.com.wolox.android.example.ui.example

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.ModelOrder
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_orders.*

class OrdersFragment : WolmoFragment<OrdersPresenter>(), OrdersView {

    override fun init() {
        presenter.init()
    }

    override fun layout(): Int = R.layout.fragment_orders

    override fun onOrdersLoaded(orders: List<ModelOrder>) {
        requireActivity().runOnUiThread {
            toggleProgress(false)
            setUpRecyclerView(orders)
        }
    }

    override fun onError() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    private fun setUpRecyclerView(orders: List<ModelOrder>) {
        vRecyclerView.apply {
            adapter = OrdersAdapter(orders)
            layoutManager = LinearLayoutManager(activity)
            isNestedScrollingEnabled = false
        }
    }

    override fun toggleProgress(toggle: Boolean) {
        vProgressBar.visibility = if (toggle) View.VISIBLE else View.GONE
    }
}