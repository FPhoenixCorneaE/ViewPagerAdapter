package com.fphoenixcorneae.widget.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

class ViewPagerItem protected constructor(
    title: CharSequence?,
    width: Float,
    @param:LayoutRes private val layoutResId: Int
) : PagerItem(title = title, width = width) {

    fun initiate(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(layoutResId, container, false)
    }

    companion object {

        fun of(
            title: CharSequence?,
            @LayoutRes layoutResId: Int,
            width: Float = DEFAULT_WIDTH
        ): ViewPagerItem {
            return ViewPagerItem(title = title, width = width, layoutResId = layoutResId)
        }
    }

}
