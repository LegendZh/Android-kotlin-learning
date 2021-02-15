package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button =findViewById(R.id.button)
       /* button.setOnClickListener {
            replaceFragment(AnotherRightFragment())
        }
        replaceFragment(RightFragment())*/
    }

    /*private fun replaceFragment(fragment:Fragment){
        val fragmentManager=supportFragmentManager //创造添加的实例
        val transaction=fragmentManager.beginTransaction() //开启事务
        transaction.replace(R.id.rightLayout,fragment) //执行调换操作
        transaction.addToBackStack(null)
        transaction.commit()
    }*/
}