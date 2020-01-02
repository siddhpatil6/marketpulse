package com.marketpulse.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Util
{
    companion object
    {
        fun setToolbar(context: AppCompatActivity, toolbar: Toolbar, name: String = "Staff") {
            context.setSupportActionBar(toolbar)
            context.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            context.supportActionBar?.setDisplayShowHomeEnabled(true)
            context.supportActionBar?.title = name

        }
    }
}