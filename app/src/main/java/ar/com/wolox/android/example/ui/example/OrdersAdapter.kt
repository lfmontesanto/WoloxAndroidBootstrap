package ar.com.wolox.android.example.ui.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R

class OrdersAdapter : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_track_order, parent, false)
        return OrderViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}