package com.fphoenixcorneae.widget.viewpager.sample

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.fphoenixcorneae.widget.viewpager.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleList = listOf("FirstFragment", "SecondFragment", "ThirdFragment", "FourFragment")

        findViewById<ViewPager>(R.id.viewPagerOne).apply {
            offscreenPageLimit = 1
            adapter = FragmentPagerItemAdapter(
                this@MainActivity,
                FragmentPagerItems.with(this@MainActivity)
                    .apply {
                        titleList.forEach {
                            add(
                                title = it,
                                clazz = SampleFragment::class.java,
                                args = Bundle().apply { putString("title", it) },
                                width = 0.25f
                            )
                        }
                    }
                    .create()
            )
        }
        findViewById<ViewPager>(R.id.viewPagerTwo).apply {
            offscreenPageLimit = 2
            adapter = FragmentStatePagerItemAdapter(
                this@MainActivity,
                FragmentPagerItems.with(this@MainActivity)
                    .apply {
                        titleList.forEach {
                            add(
                                title = it,
                                clazz = SampleFragment::class.java,
                                args = Bundle().apply { putString("title", it) },
                                width = 0.5f
                            )
                        }
                    }
                    .create(),
            )
        }
        findViewById<ViewPager>(R.id.viewPagerThree).apply {
            offscreenPageLimit = 2
            adapter = ViewPagerItemAdapter(
                ViewPagerItems.with(this@MainActivity)
                    .apply {
                        titleList.forEach {
                            add(title = it, layoutResId = R.layout.layout_pager, width = 0.8f)
                        }
                    }
                    .create(),
            )
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                }

                override fun onPageSelected(position: Int) {
                    (adapter as ViewPagerItemAdapter?)?.getPage(position)?.findViewById<View>(R.id.clRoot)
                        ?.setBackgroundColor(getRandomColor())
                    (adapter as ViewPagerItemAdapter?)?.getPage(position)?.findViewById<TextView>(R.id.tvTitle)?.text =
                        titleList[position]
                }

                override fun onPageScrollStateChanged(state: Int) {
                }

            })
        }
        findViewById<ViewPager2>(R.id.viewPager2).apply {
            offscreenPageLimit = 1
            adapter = FragmentStatePager2ItemAdapter(
                this@MainActivity,
                FragmentPagerItems.with(this@MainActivity)
                    .apply {
                        titleList.forEach {
                            add(
                                title = it,
                                clazz = SampleFragment::class.java,
                                args = Bundle().apply { putString("title", it) },
                                width = 1f
                            )
                        }
                    }
                    .create(),
                lifecycle
            )
        }
    }
}