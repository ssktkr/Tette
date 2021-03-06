package com.example.tette

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tette.ui.main.SectionsPagerAdapter
import com.example.tette.Frag00
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val date = DateActivity()
        val title:TextView = findViewById(R.id.date)
        title.text = date.getDate()


        if(getTime() != "午後 9") {
            val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
            val viewPager: ViewPager = findViewById(R.id.view_pager)
            viewPager.adapter = sectionsPagerAdapter
            val tabs: TabLayout = findViewById(R.id.tabs)
            tabs.setupWithViewPager(viewPager)

            tabs.getTabAt(0)?.setIcon(R.drawable.ic_action_left)
            tabs.getTabAt(1)?.setIcon(R.drawable.ic_action_right)
        }else{
            Quiz()
        }







       // val fab: FloatingActionButton = findViewById(R.id.fab)

        //fab.setOnClickListener { view ->
        //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //            .setAction("Action", null).show()
        //}

    }

    private fun getTime():String{
        val date: Calendar = Calendar.getInstance()
        var am_pm: String? = null
        when(date.get(Calendar.AM_PM)){
            0 -> am_pm = "午前"
            1 -> am_pm = "午後"
        }
        val hour: Int= date.get(Calendar.HOUR_OF_DAY)
        val min: Int = date.get(Calendar.MINUTE)

        return "$am_pm $hour"



    }





}