package com.mayumi.loterica.util

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils

fun animar(view: View, int: Int, context: Context) {
    val anime = AnimationUtils.loadAnimation(context, int)
    view.startAnimation(anime)
}