package com.fphoenixcorneae.widget.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.viewpager.widget.PagerAdapter
import java.lang.ref.WeakReference

class ViewPagerItemAdapter(
    private val mPages: ViewPagerItems,
) : PagerAdapter() {

    private val mHolder: SparseArrayCompat<WeakReference<View>> = SparseArrayCompat(mPages.size)

    override fun getCount(): Int {
        return mPages.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = getPage(position) ?: getPagerItem(position).initiate(LayoutInflater.from(mPages.context), container)
            .also {
                mHolder.put(position, WeakReference(it))
            }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` === view
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return getPagerItem(position).title
    }

    override fun getPageWidth(position: Int): Float {
        return getPagerItem(position).width
    }

    fun getPage(position: Int): View? {
        val weakRefItem = mHolder.get(position)
        return weakRefItem?.get()
    }

    private fun getPagerItem(position: Int): ViewPagerItem {
        return mPages[position]
    }
}
