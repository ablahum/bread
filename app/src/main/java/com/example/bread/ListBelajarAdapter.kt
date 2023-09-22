package com.example.bread

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBelajarAdapter(private val list: ArrayList<Bread>) :
    RecyclerView.Adapter<ListBelajarAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val context = holder.itemView.context
        val bread = list[position]

        holder.name.text = bread.name
        holder.desc.text = bread.desc
        Glide.with(holder.itemView.context)
            .load(bread.img)
            .apply(RequestOptions())
            .into(holder.img)

        holder.itemView.setOnClickListener {
            val items = Intent(context, DetailActivity::class.java)

            items.putExtra(DetailActivity.EXTRA_NAME, bread.name)
            items.putExtra(DetailActivity.EXTRA_DESC, bread.desc)
            items.putExtra(DetailActivity.EXTRA_IMG, bread.img)

            context.startActivity(items)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.row_name)
        var desc: TextView = itemView.findViewById(R.id.row_desc)
        var img: ImageView = itemView.findViewById(R.id.row_img)
    }
}