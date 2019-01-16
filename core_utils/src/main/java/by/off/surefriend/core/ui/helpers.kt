package by.off.surefriend.core.ui

import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import by.off.surefriend.core.R

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun SwipeRefreshLayout.setupDefault(listener: (() -> Unit) = {}) {
    this.setColorSchemeResources(R.color.refresh1, R.color.refresh2, R.color.refresh3)
    this.setOnRefreshListener { listener() }
}