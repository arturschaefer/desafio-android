package com.schaefer.user.presentation.userlist.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.schaefer.user.R
import com.schaefer.user.presentation.model.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.*
import kotlinx.android.synthetic.main.item_user.view.*
import timber.log.Timber

class UserListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    fun bind(user: User) {
        tvName.text = user.name
        tvUsername.text = user.username
        pbUserImage.visibility = View.VISIBLE

        try {
            Picasso.get()
                .load(user.img)
                .error(R.drawable.ic_round_account_circle)
                .into(civUserImage, callBack)
        } catch (ex: Exception) {
            Picasso.get()
                .load(R.drawable.ic_round_account_circle)
                .placeholder(R.drawable.ic_round_account_circle)
                .into(civUserImage, callBack)
            Timber.e(ex)
        }
    }

    val callBack = object : Callback {
        override fun onSuccess() {
            pbUserImage.isVisible = false
        }

        override fun onError(e: Exception?) {
            pbUserImage.isVisible = false
        }
    }

    override val containerView: View?
        get() = itemView
}