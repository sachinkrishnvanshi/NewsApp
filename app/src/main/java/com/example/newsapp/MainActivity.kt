package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        main_viewpager.adapter=ViewPagerAdapter(this)
        image_back.setOnClickListener {


            val intent= Intent(this@MainActivity,MainActivity::class.java)
            startActivity(intent)
        }

        main_viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if(position==0){
                    tv_middle.text="Discover"
                    image_setting.visibility=View.VISIBLE
                    tv_back.visibility=View.INVISIBLE
                    image_back.visibility=View.INVISIBLE

                    tv_next.text="Top Stories"
                    tv_next.visibility=View.VISIBLE
                    image_next.visibility=View.VISIBLE
                    image_top.visibility=View.INVISIBLE
                    image_load.visibility=View.INVISIBLE

                }
                else{
                    tv_middle.text="Top Stories"
                    tv_back.text="Discover"
                    image_top.setImageResource(R.drawable.ic_baseline_vertical_align_top_24)
                    image_top.visibility=View.VISIBLE
                    image_next.visibility=View.INVISIBLE
                    image_setting.visibility=View.INVISIBLE
                    tv_back.visibility=View.VISIBLE
                    image_back.visibility=View.VISIBLE
                    tv_next.visibility=View.INVISIBLE
                    image_load.visibility=View.INVISIBLE

                }
            }

        })

    }



}