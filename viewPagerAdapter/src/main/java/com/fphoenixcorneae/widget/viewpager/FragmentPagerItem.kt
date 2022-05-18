package com.fphoenixcorneae.widget.viewpager

import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentPagerItem private constructor(
    title: CharSequence?,
    private val className: String,
    private val args: Bundle,
    width: Float
) : PagerItem(title, width) {

    fun instantiate(fm: FragmentManager, context: Context, position: Int): Fragment {
        return fm.fragmentFactory.instantiate(context.classLoader, className).apply {
            args.classLoader = javaClass.classLoader
            arguments = args
        }
    }

    companion object {
        fun of(
            title: CharSequence?,
            clazz: Class<out Fragment>,
            args: Bundle = Bundle(),
            width: Float = DEFAULT_WIDTH
        ): FragmentPagerItem {
            return FragmentPagerItem(title = title, className = clazz.name, args = args, width = width)
        }
    }
}
