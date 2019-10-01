package ar.com.wolox.android.example.ui.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.ModelOrder
import kotlinx.android.synthetic.main.viewholder_order.view.*

class OrdersAdapter(private var orders: List<ModelOrder>) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_order, parent, false)
        return OrderViewHolder(viewHolder)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        orders[position].let {
            with(holder) {
                orderId.text = it.id
                username.text = it.user?.username ?: ""
                orderTotal.text = it.totalAmount.toString()
                deliveryAddress.text = it.deliveryAddress
            }
        }
    }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.vOrderId
        val deliveryAddress: TextView = itemView.vDeliveryAddress
        val orderTotal: TextView = itemView.vOrderTotal
        val username: TextView = itemView.vUsername
    }
}