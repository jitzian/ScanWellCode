package com.example.scanwellchallenge.showRepos.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.scanwellchallenge.R
import com.example.scanwellchallenge.rest.model.Item
import com.example.scanwellchallenge.showRepos.callback.ItemClickListener
import com.squareup.picasso.Picasso

class RVCustomAdapter(
    private val lstRes: List<Item>?,
    private val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lstRes?.get(position)?.let { item ->
            holder.bindData(item)
            holder.itemView.setOnClickListener {
                itemClickListener.onItemClickListener(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return lstRes?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mImageViewAvatar: ImageView = itemView.findViewById(R.id.mImageViewAvatar)
        private val mTextViewItemName: TextView = itemView.findViewById(R.id.mTextViewItemName)
        private val mTextViewItemAccountId: TextView =
            itemView.findViewById(R.id.mTextViewItemAccountId)

        private val mImageViewItemGolBadgeIcon: ImageView =
            itemView.findViewById(R.id.mImageViewItemGolBadgeIcon)
        private val mTextViewItemGoldBadge: TextView =
            itemView.findViewById(R.id.mTextViewItemGoldBadge)

        private val mImageViewItemSilverBadgeIcon: ImageView =
            itemView.findViewById(R.id.mImageViewItemSilverBadgeIcon)
        private val mTextViewItemSilverBadge: TextView =
            itemView.findViewById(R.id.mTextViewItemSilverBadge)

        private val mImageViewItemBronzeBadgeIcon: ImageView =
            itemView.findViewById(R.id.mImageViewItemBronzeBadgeIcon)
        private val mTextViewItemBronzeBadge: TextView =
            itemView.findViewById(R.id.mTextViewItemBronzeBadge)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bindData(data: Item) {
            Picasso.get()
                .load(data.profileImage)
                .into(mImageViewAvatar)

            mTextViewItemName.text = data.displayName
            mTextViewItemAccountId.text = data.accountId.toString()

            mTextViewItemGoldBadge.text = data.badgeCounts?.gold.toString()

            mTextViewItemSilverBadge.text = data.badgeCounts?.silver.toString()
            val silverIcon =
                ContextCompat.getDrawable(itemView.context, R.drawable.bronze)?.mutate()
            silverIcon?.setTint(Color.GRAY)
            mImageViewItemSilverBadgeIcon.setImageDrawable(silverIcon)

            mTextViewItemBronzeBadge.text = data.badgeCounts?.bronze.toString()

        }
    }
}