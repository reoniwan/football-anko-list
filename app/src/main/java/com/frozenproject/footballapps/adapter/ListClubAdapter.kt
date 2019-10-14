package com.frozenproject.footballapps.adapter

import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frozenproject.footballapps.data.FootballTeam
import com.frozenproject.footballapps.view.ItemViewUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext


class ListClubAdapter(
    private val context: Context,
    private val clubFootball: List<FootballTeam>,
    private val listener: (FootballTeam) -> Unit
) : RecyclerView.Adapter<ListClubAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        return CardViewViewHolder(ItemViewUI().createView(AnkoContext.create(context, parent)))
    }

    override fun getItemCount(): Int = clubFootball.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bindItem(clubFootball[position], listener)
    }

    inner class CardViewViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        var tvName: TextView = itemView.findViewById(ItemViewUI.tv_item)
        var ivClub: ImageView = itemView.findViewById(ItemViewUI.img_item)


        fun bindItem(items: FootballTeam, listener: (FootballTeam) -> Unit) {
            tvName.text = items.teamName
            Glide.with(containerView)
                .load(items.imgTeam)
                .into(ivClub)

            containerView.setOnClickListener { listener(items) }
        }

    }

}