package com.fphoenixcorneae.widget.viewpager

import android.content.Context

import androidx.annotation.LayoutRes
import androidx.annotation.StringRes

class ViewPagerItems private constructor(
    context: Context
) : PagerItems<ViewPagerItem>(context) {

    class Creator(context: Context) {

        private val items: ViewPagerItems = ViewPagerItems(context)

        fun add(
            @StringRes title: Int,
            @LayoutRes layoutResId: Int,
            width: Float = PagerItem.DEFAULT_WIDTH
        ): Creator {
            return add(ViewPagerItem.of(items.context.getString(title), layoutResId, width))
        }

        fun add(
            title: CharSequence,
            @LayoutRes layoutResId: Int,
            width: Float = PagerItem.DEFAULT_WIDTH
        ): Creator {
            return add(ViewPagerItem.of(title, layoutResId, width))
        }

        fun add(item: ViewPagerItem): Creator {
            items.add(item)
            return this
        }

        fun create(): ViewPagerItems {
            return items
        }
    }

    companion object {

        fun with(context: Context): Creator {
            return Creator(context)
        }
    }
}
