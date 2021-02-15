package com.example.helloworld

//定义一个基本的，可继承的类
open class Person(val name:String,val age: Int) {
    fun eat(){
        println("$name is eating. He is $age years old")
    }
}