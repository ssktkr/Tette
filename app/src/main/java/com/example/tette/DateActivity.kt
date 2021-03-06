package com.example.tette

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class DateActivity{
    fun getDate():CharSequence{

        val calendar: Calendar = Calendar.getInstance()
        val date: Date = Date()
        val sdf:SimpleDateFormat = SimpleDateFormat("yyyy'年'MM'月'dd'日'")
        var weekday: String? = null
        when(calendar.get(Calendar.DAY_OF_WEEK)){
            1-> weekday = "日"
            2-> weekday = "月"
            3-> weekday = "火"
            4-> weekday = "水"
            5-> weekday = "木"
            6-> weekday = "金"
            7-> weekday = "土"

        }
        return "${sdf.format(date)}(${weekday})"


    }



}