package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThirdActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ThirdActivity","Task id is $taskId")
        setContentView(R.layout.third_layout)
        //用这个按钮退出程序,并且销毁所有Activity
        val button3: Button=findViewById(R.id.button3)
        button3.setOnClickListener {
            ActivityCollector.finishAll()
        }
    }

}