package com.fphoenixcorneae.widget.viewpager

import android.content.Context

import java.util.ArrayList

abstract class PagerItems<T : PagerItem> protected constructor(
    val context: Context
) : ArrayList<T>()
