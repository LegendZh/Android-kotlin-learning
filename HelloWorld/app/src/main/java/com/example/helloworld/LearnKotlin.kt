package com.example.helloworld

import kotlin.math.max

//if的简化使用方法
fun largerNumber(param1:Int,param2:Int)=if (param1>param2) param1 else param2

//when(switch)的简化使用方法
fun getScore(name:String)=when{
    name.startsWith("Tom")->86 //开头是Tom的都被这样赋值
    name=="Jim"->99
    name=="Frank"->100
    name=="Lily"->50
    else->0
}

//Number:统称为数字的大类， Int，Double等等都是这个类下面下辖的子类
fun checkNumber(num:Number){
    when(num){
        is Int->println("number is Int")
        is Double->println("number is Double")
        else -> println("number is not support")
    }
}

//for循环的写法
fun loopFunction(){
    for(i in 0..10){
        println(i)
    }
}

//隔步循环
fun stepLoop(){
    for(i in 0..10 step 2){
        println(i)
    }
}

//反向循环,downTo后面的数指的是到几
//反向隔步循环，只需要在后面指定step即可
fun reverseLoop(){
    for(i in 10 downTo 2){
        println(i)
    }
}

fun main(){
    val list= mutableSetOf("Apple","Banana","Orange","Pear","Watermelon")
    val newList=list.filter { it.length<=5 }.map { it.toUpperCase() }
    for (fruit in newList){
        println(fruit)
    }
}