package com.example.activitytest

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        //取出由FirstActivity传递的数据并打印出来
        //val extraData=intent.getStringExtra("extra_data") //通过前一个变量的传递的标记去获取
        //Log.d("SecondActivity","extra data is $extraData")
        //设定返回到上一个Activity的时候传输数据
        val button2:Button=findViewById(R.id.button2)
        button2.setOnClickListener{
            val intent=Intent(this,ThirdActivity::class.java)
            startActivity(intent)
            //intent.putExtra("data_return","Hello FirstActivity")
            //setResult(Activity.RESULT_OK,intent)
            //finish()
        }
    }
    //传递前一个Activity参数的另一种写法，类似于Java中的匿名类的写法
    companion object{
        fun actionstart(context: Context, data1:String, data2:String){
            val intent=Intent(context,SecondActivity::class.java)
            intent.putExtra("param1",data1)
            intent.putExtra("param1",data2)
            context.startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity","onDestroy")
    }
}