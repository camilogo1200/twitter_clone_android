package com.example.mptwitterclone.common

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isGone
import com.google.android.material.snackbar.Snackbar


fun showSnackBarError(
    context: Context,
    view: View,
    message: String,
    @ColorRes backgroundColor: Int = R.color.blue,
    listener: (() -> Unit)? = null
) {
    val resources = context.resources
    Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
        .setAction("OK") {
            it.isGone = true
            listener?.invoke()
        }
        .setBackgroundTint(
            ResourcesCompat.getColor(
                resources,
                backgroundColor,
                null
            )
        )
        .setActionTextColor(
            ResourcesCompat.getColor(
                resources,
                R.color.extra_extra_light_grey,
                null
            )
        )
        .setTextColor(
            ResourcesCompat.getColor(
                resources,
                R.color.extra_extra_light_grey,
                null
            )
        )
        .show()
}
