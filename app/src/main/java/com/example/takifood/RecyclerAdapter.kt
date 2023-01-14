package com.example.takifood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    //Image List
    private val images = intArrayOf(
        R.drawable.makanan,
        R.drawable.minuman,
        R.drawable.cemilan,
    )
    //title list
    private val titles = arrayOf(
        "Makanan",
        "Minuman",
        "Cemilan",
    )
    //view holder class
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle : TextView
        init {
            itemImage = itemView.findViewById(R.id.card_image)
            itemTitle = itemView.findViewById(R.id.cardTitle)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                    Snackbar.make(v, "Click on Item ${titles[position]}",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    //onCreateViewHolder()
    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(ViewGroup.context)
            .inflate(R.layout.fragment_home, ViewGroup, false)
        return ViewHolder(v)
    }
    //onBindingViewHolder()
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemImage.setImageResource(images[i])
    }
    //getItemCount()
    override fun getItemCount(): Int {
        return titles.size
    }
}