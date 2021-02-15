package com.example.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //private val data= listOf("Apple","Banana","Orange","Watermelon",
    //       "Pear","Grape","Pineapple","Strawberry","Cherry","Mango",
     //      "Apple","Banana","Orange","Watermelon","Pear","Grape",
     //       "Pineapple","Strawberry","Cherry","Mango")
    private val fruitList=ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits() //初始化水果数据
        //使用适配器将数据传入到界面上
        val adapter=FruitAdapter(this,R.layout.fruit_item,fruitList)
        val listView:ListView=findViewById(R.id.listView)
        listView.adapter=adapter
        //注册list的点击事件
        listView.setOnItemClickListener{parent,view,position,id->
            val fruit=fruitList[position]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits(){
        repeat(10){
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))

        }
    }
}