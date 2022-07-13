package com.example.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.NewsFragment
import com.example.newsapp.QuoteFragment
import com.example.newsapp.callBack.DataTransferNews


class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                QuoteFragment()
            }
            1 -> {
                NewsFragment()
            }
            else -> {
                Fragment()
            }
        }

    }
}
