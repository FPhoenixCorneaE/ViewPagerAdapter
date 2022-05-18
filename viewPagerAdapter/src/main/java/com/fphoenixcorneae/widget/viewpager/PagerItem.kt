package com.fphoenixcorneae.widget.viewpager

import androidx.annotation.FloatRange

abstract class PagerItem protected constructor(
    /**
     * 每页的标题，多用于关联indicator
     */
    val title: CharSequence?,
    /**
     * 指定的页面相对于ViewPager宽度的比例
     */
    @FloatRange(from = 0.0, to = 1.0) val width: Float
) {
    companion object {
        const val DEFAULT_WIDTH = 1f
    }
}
