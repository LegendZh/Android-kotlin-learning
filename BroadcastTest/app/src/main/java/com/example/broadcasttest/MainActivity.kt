package com.example.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter=IntentFilter()
        //添加实例，每当发生改变的时候就会生成一条广播
        intentFilter.addAction("android.intent.action.TIME_TICK")
        //实例化一个监听端口receiver
        timeChangeReceiver=TimeChangeReceiver()
        //注册一个监听器，实现对于活动的监听以及有所响应
        registerReceiver(timeChangeReceiver,intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context,"Time has changed",Toast.LENGTH_SHORT).show()
        }
    }
}