package com.example.uilayouttest

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class TitleLayout(context:Context,attrs:AttributeSet):LinearLayout(context,attrs) {
    init{
        LayoutInflater.from(context).inflate(R.layout.title,this)
        //注册点击事件
        val titleBack:Button=findViewById(R.id.titleBack)
        val titleEdit:Button=findViewById(R.id.titleEdit)
        titleBack.setOnClickListener{
            val activity=context as Activity
            activity.finish()
        }
        titleEdit.setOnClickListener {
            Toast.makeText(context,"You chliked Edit button",Toast.LENGTH_SHORT).show()
        }
    }

}