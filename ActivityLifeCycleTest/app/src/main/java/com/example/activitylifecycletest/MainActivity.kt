package com.example.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val tag="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag,"onCreate")
        setContentView(R.layout.activity_main)
        //设置按键的功能
        val startNormalActivity:Button=findViewById(R.id.startNormalActivity)
        val startDialogActivity:Button=findViewById(R.id.startDialogActivity)
        startNormalActivity.setOnClickListener {
            val intent= Intent(this,NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener {
            val intent=Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
        //加上这段代码保证数据成功被保存下来
        if(savedInstanceState!=null){
            val tempData=savedInstanceState.getString("data_key")
            if (tempData != null) {
                Log.d(tag,tempData)
            }
        }
    }
    override fun onStart(){
        super.onStart()
        //记录调用了这个方法
        Log.d(tag,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempdata="Something you just typed"
        outState.putString("data_key",tempdata)
    }
}