package com.fphoenixcorneae.widget.viewpager

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

class FragmentPagerItems private constructor(
    context: Context
) : PagerItems<FragmentPagerItem>(context) {

    class Creator(context: Context) {

        private val mPagerItems: FragmentPagerItems = FragmentPagerItems(context)

        fun add(
            @StringRes title: Int,
            clazz: Class<out Fragment>,
            args: Bundle = Bundle(),
            width: Float = PagerItem.DEFAULT_WIDTH
        ): Creator {
            return add(
                FragmentPagerItem.of(
                    title = mPagerItems.context.getString(title),
                    clazz = clazz,
                    width = width,
                    args = args
                )
            )
        }

        fun add(
            title: CharSequence?,
            clazz: Class<out Fragment>,
            args: Bundle = Bundle(),
            width: Float = PagerItem.DEFAULT_WIDTH
        ): Creator {
            return add(FragmentPagerItem.of(title = title, clazz = clazz, width = width, args = args))
        }

        fun add(item: FragmentPagerItem): Creator {
            mPagerItems.add(item)
            return this
        }

        fun create(): FragmentPagerItems {
            return mPagerItems
        }
    }

    companion object {

        fun with(context: Context): Creator {
            return Creator(context)
        }
    }
}
