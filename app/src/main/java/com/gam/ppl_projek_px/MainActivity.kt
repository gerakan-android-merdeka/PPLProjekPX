package com.gam.ppl_projek_px

import android.content.Intent
import android.drm.DrmStore
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.SQLOutput

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_menu -> {
                val fragment = HomeFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.listen_menu-> {
                val fragment = ListenFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.news_menu-> {
                val fragment = NewsFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }

    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        addFragment(fragment)

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
//        getSupportActionBar().setDisplayOptions(A)
//        val actionBar = supportActionBar
//        getSupportActionBar().setDisplayShowHomeEnabled(true)
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher)
//        getSupportActionBar().setDisplayUseLogoEnabled(true)
//        supportActionBar(actionBar).setDisplayShowHomeEnabled(true)




    }




}
