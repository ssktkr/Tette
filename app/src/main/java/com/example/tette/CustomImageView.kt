package com.example.tette

import androidx.appcompat.widget.AppCompatImageView
import android.content.Context
import android.util.AttributeSet

class CustomImageView: AppCompatImageView {
    constructor(context: Context,attrs:AttributeSet):super(context,attrs)

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

}