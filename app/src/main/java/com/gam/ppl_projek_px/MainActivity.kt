package com.gam.ppl_projek_px

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v){
            button->{
                val intent = Intent(this, BActivity::class.java)
                startActivity(intent)
            }
            button2->{}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener(this)
        button2.setOnClickListener(this)
    }
}
