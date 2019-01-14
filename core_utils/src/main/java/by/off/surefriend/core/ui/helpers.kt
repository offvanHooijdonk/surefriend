package by.off.surefriend.core.ui

import android.support.v4.widget.SwipeRefreshLayout
import by.off.surefriend.core.R

fun SwipeRefreshLayout.setupDefault(listener: (() -> Unit) = {}) {
    this.setColorSchemeResources(R.color.refresh1, R.color.refresh2, R.color.refresh3)
    this.setOnRefreshListener { listener() }
}