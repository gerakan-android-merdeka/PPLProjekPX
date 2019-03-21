package com.gam.ppl_projek_px

import android.content.Intent
import android.drm.DrmStore
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.welcome1.*
import java.sql.SQLOutput

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var content: FrameLayout? = null

    lateinit var toolbar: Toolbar

    fun showIntroAgain(v: View) {
        PrefManager(this).clearPreference()
        val intent = Intent(this, OnBoardActivity::class.java)
        startActivity(intent)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        navigation.menu.getItem(0).setIcon(R.drawable.home)
        navigation.menu.getItem(1).setIcon(R.drawable.hearing_menu)
        navigation.menu.getItem(2).setIcon(R.drawable.news_menu)
        when (item.itemId) {
            R.id.home_menu -> {
                val fragment = HomeFragment.newInstance()
                addFragment(fragment)
                item.setIcon(R.drawable.home_menu)
                return@OnNavigationItemSelectedListener true

            }
            R.id.listen_menu -> {
                val fragment = ListenFragment()
                addFragment(fragment)
                item.setIcon(R.drawable.hearing)
                return@OnNavigationItemSelectedListener true
            }
            R.id.news_menu -> {
                val fragment = NewsFragment()
                addFragment(fragment)
                item.setIcon(R.drawable.news)
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
        val context = this
        when (v!!.id) {
            R.id.klikaja -> {
//                val intent = Intent(context, OnBoardActivity::class.java)
//                startActivity(intent)
                Toast.makeText(context, "tesf sdkfjkndsfkd", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        toolbar = findViewById(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        addFragment(fragment)

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
//        getSupportActionBar().setDisplayOptions(A)
//        getSupportActionBar().setDisplayShowHomeEnabled(true)
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher)
//        getSupportActionBar().setDisplayUseLogoEnabled(true)
//        supportActionBar(actionBar).setDisplayShowHomeEnabled(true)
//        android.R.attr.toolbarStyle
//        supportActionBar?.setLogo(R.mipmap.ic_launcher_round)

        val actionBar = supportActionBar
        actionBar!!.title = "  Pilkadangu Lite"
//        actionBar!!.subtitle = "Ini adalah Subtitle"

//        display icon on the action bar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.setLogo(R.drawable.logo)
        actionBar.setDisplayUseLogoEnabled(true)


    }


}
