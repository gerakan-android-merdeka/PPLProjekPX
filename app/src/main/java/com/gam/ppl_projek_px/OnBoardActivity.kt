package com.gam.ppl_projek_px

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hololo.tutorial.library.TutorialActivity
import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.app.IntentService
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.RED
import android.graphics.Color.parseColor
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.hololo.tutorial.library.Step
import kotlinx.android.synthetic.main.activity_welcome.*
import java.text.FieldPosition


class OnBoardActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mPager: ViewPager

    var layouts: IntArray = intArrayOf(
        com.gam.ppl_projek_px.R.layout.welcome1,
        com.gam.ppl_projek_px.R.layout.welcome2,
        com.gam.ppl_projek_px.R.layout.welcome3

    )

    lateinit var dotsLayout: LinearLayout

    lateinit var dots: Array<ImageView>

    lateinit var mAdapter : PageAdapter

    // button skip and next
    lateinit var btnSkip : Button
    lateinit var btnNext : Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (PrefManager(this).checkPreference()) {
            loadHome()
        }

        if (Build.VERSION.SDK_INT >= 19) {

            window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)

        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        }

        setContentView(com.gam.ppl_projek_px.R.layout.activity_on_board)

        mPager = findViewById(com.gam.ppl_projek_px.R.id.pager) as ViewPager
        mAdapter = PageAdapter(layouts, this)
        mPager.adapter = mAdapter
        // button skip and next
        dotsLayout = findViewById(com.gam.ppl_projek_px.R.id.dots) as LinearLayout
        btnSkip    = findViewById(com.gam.ppl_projek_px.R.id.btn_skip) as Button
        btnNext    = findViewById(com.gam.ppl_projek_px.R.id.btn_next) as Button
        btnSkip.setOnClickListener(this)
        btnNext.setOnClickListener(this)


        createDots(0)
        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                createDots(p0)

                if (p0 == layouts.size - 1) {
                    btnNext.setText(com.gam.ppl_projek_px.R.string.start)
                    btnSkip.visibility = View.INVISIBLE
                } else {
                    btnNext.setText(com.gam.ppl_projek_px.R.string.next)
//                    btnSkip.visibility = View.VISIBLE
                }

            }

        })

    }


        override fun onClick(v: View?) {

        when (v!!.id) {
            com.gam.ppl_projek_px.R.id.btn_skip -> {
                loadHome()
                PrefManager(this).writeSP()

            }

            com.gam.ppl_projek_px.R.id.btn_next -> {
                loadNextSlide()
            }

        }

    }

    private fun loadNextSlide() {
        var nextSlide : Int = mPager.currentItem + 1

        if (nextSlide < layouts.size) {
            mPager.setCurrentItem(nextSlide)
        } else {
            loadHome()
            PrefManager(this).writeSP()
        }
    }

    private fun loadHome() {
        startActivity(Intent(this, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        finish()
    }

    fun createDots(position: Int) {
        if (dotsLayout != null) {
            dotsLayout!!.removeAllViews()
        }

        dots = Array(layouts.size,{i -> ImageView(this) })

        for (i in 0..layouts.size - 1) {

            dots[i] = ImageView(this)

            if (i == position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, com.gam.ppl_projek_px.R.drawable.active_dots))
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, com.gam.ppl_projek_px.R.drawable.inactive_dots))
            }

            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

            params.setMargins(18, 0, 18, 0)
            dotsLayout.addView(dots[i], params)


        }

    }

}
