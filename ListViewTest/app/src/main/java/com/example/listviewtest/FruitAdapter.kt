package com.example.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(activity: Activity,val resourceId:Int,data:List<Fruit>):
    ArrayAdapter<Fruit>(activity,resourceId,data) {
    inner class ViewHolder(val fruitImage:ImageView,val friutName:TextView)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View
        //保证在滚动界面的时候不会重新去读取
        val viewHolder:ViewHolder
        //保证在滚动的时候不会总是重新加载页面
        if (convertView==null){
            view=LayoutInflater.from(context).inflate(resourceId,parent,false)
            //利用内部类对已经获取到的对象进行缓存
            val fruitImage:ImageView=view.findViewById(R.id.fruitImage)
            val fruitName:TextView=view.findViewById(R.id.fruitName)
            viewHolder=ViewHolder(fruitImage,fruitName)
            view.tag=viewHolder
        }else{
            //如果发现已经存在了，那么我们直接载入缓存的内容
            view=convertView
            viewHolder=view.tag as ViewHolder
        }
        val fruit=getItem(position) //获取当前的Fruit实例
        if(fruit!=null){
            viewHolder.fruitImage.setImageResource(fruit.imageId)//设置显示的图片
            viewHolder.friutName.text=fruit.name//设置显示的文字
        }
        return view
    }
}