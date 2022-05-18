package com.fphoenixcorneae.widget.viewpager.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import com.fphoenixcorneae.widget.viewpager.R

class SampleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false).apply {
            findViewById<View>(R.id.clRoot).setBackgroundColor(getRandomColor())
            findViewById<TextView>(R.id.tvTitle).text = arguments?.getString("title")
        }
    }
}

@ColorInt
fun getRandomColor(
    supportAlpha: Boolean = true
): Int {
    val high =
        when {
            supportAlpha -> (Math.random() * 0x100).toInt() shl 24
            else -> -0x1000000
        }
    return high or (Math.random() * 0x1000000).toInt()
}