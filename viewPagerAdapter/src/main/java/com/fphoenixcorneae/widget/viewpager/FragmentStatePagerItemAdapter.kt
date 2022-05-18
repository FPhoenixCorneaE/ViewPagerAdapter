package com.fphoenixcorneae.widget.viewpager

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentStatePagerItemAdapter : FragmentStatePagerAdapter {

    private val mPages: FragmentPagerItems
    private var mFragmentManager: FragmentManager

    constructor(
        fragmentActivity: FragmentActivity,
        pages: FragmentPagerItems,
    ) : super(fragmentActivity.supportFragmentManager) {
        this.mFragmentManager = fragmentActivity.supportFragmentManager
        this.mPages = pages
    }

    constructor(
        fragment: Fragment,
        pages: FragmentPagerItems,
    ) : super(fragment.childFragmentManager) {
        this.mFragmentManager = fragment.childFragmentManager
        this.mPages = pages
    }

    override fun getCount(): Int {
        return mPages.size
    }

    override fun getItem(position: Int): Fragment {
        return getPagerItem(position).instantiate(mFragmentManager, mPages.context, position)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return getPagerItem(position).title
    }

    override fun getPageWidth(position: Int): Float {
        return getPagerItem(position).width
    }

    private fun getPagerItem(position: Int): FragmentPagerItem {
        return mPages[position]
    }
}
