package com.liftechnology.tvazteca.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liftechnology.tvazteca.R
import com.liftechnology.tvazteca.data.model.responseTvAzteca.Item
import com.liftechnology.tvazteca.model.ListenerHome


class ItemsAdapter(
    var itemList: List<Item>,
    var clickListener: ListenerHome
):
    RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    class ItemsViewHolder (view: View):RecyclerView.ViewHolder(view){
        private val imgItem = view.findViewById<ImageView>(R.id.card_image)
        fun bind(item: Item, action: ListenerHome) {
            Glide.with(imgItem.context).load(item.imagen).into(imgItem)

            itemView.setOnClickListener {
                action.itemClicked(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemsViewHolder(inflater.inflate(R.layout.picture_card, parent, false))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(itemList[position], clickListener)
    }

    override fun getItemCount(): Int = itemList.size

}

