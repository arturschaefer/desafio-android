package com.schaefer.actions

import android.content.Context
import android.content.Intent

object Actions {
    private fun createIntent(context: Context, action: String) =
        Intent(action).setPackage(context.packageName)

    object User{
        fun openUserList(context: Context) {
            context.startActivity(
                createIntent(
                    context = context,
                    action = context.getString(R.string.action_user)
                ).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            )
        }
    }
}