package com.hofit.hofitcellcomtest.extentions

import android.view.View

fun View.show(show: Boolean) {
    when (show) {
        true -> {
            this.visibility = View.VISIBLE
        }
        false -> {
            this.visibility = View.GONE
        }
    }
}