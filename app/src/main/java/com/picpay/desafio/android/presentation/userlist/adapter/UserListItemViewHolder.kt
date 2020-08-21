package com.picpay.desafio.android.presentation.userlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.presentation.model.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User) {
        itemView.tvName.text = user.name
        itemView.tvUsername.text = user.username
        itemView.pbUserImage.visibility = View.VISIBLE
        Picasso.get()
            .load(user.img)
            .error(R.drawable.ic_round_account_circle)
            .into(itemView.civUserImage, object : Callback {
                override fun onSuccess() {
                    itemView.pbUserImage.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    itemView.pbUserImage.visibility = View.GONE
                }
            })
    }
}