package com.example.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity","Task id is $taskId")
        setContentView(R.layout.first_layout)
        val button1:Button= findViewById(R.id.button1)

        button1.setOnClickListener{
            //1.触发事件，点一下下面会有一定的提示
            //Toast.makeText(this,"我最爱你啊",Toast.LENGTH_SHORT).show()
            //2.切换到下一个Activity的代码
            //val intent=Intent(this,SecondActivity::class.java)
            //3.隐式调用Intent
            //不需要调用category的原因是在调用的时候会自动去匹配标签值为default的category标签
            //val intent=Intent("com.example.activitytest.ACTION_START")
            //intent.addCategory("com.example.activitytest.MY_CATEGORY")
            //4.隐式调用的作用：实现多个应用Activity的共享
            //val intent=Intent(Intent.ACTION_VIEW)
            //实现对于打开系统浏览器，对于网页的调用
            //intent.data= Uri.parse("https://www.baidu.com")
            //startActivity(intent)
            //5.实现多个Activity之间数据的传输，这里是传向下一个Activity的数据
            //val data="Hello SecondActivity"
            //在SecondActivity中写好匿名类代码之后，直接调用就可以完成切换
            SecondActivity.actionstart(this,"data1","data2")
        }
    }

    //接收上一个Activity返回的数据
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1-> if(resultCode== Activity.RESULT_OK){
                val returnedData=data?.getStringExtra("data_return")
                Log.d("FirstActivity","returned data is $returnedData")
            }

        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity","onRestart")
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //相当于调用了MenuInflater类的对象的getter方法
        //然后再调用这里面的inflate方法，来完成创建菜单的工作
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //类似切换
        when(item.itemId){
            R.id.add_item->Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show()
            R.id.remove_item->Toast.makeText(this,"You clicked remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}