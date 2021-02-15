package com.example.helloworld

class Student(val stuNo:String,val grade:Int,name:String,age:Int):Person(name,age),Study{
    constructor(name: String,age: Int):this("",0,name, age){}
    constructor():this("",0){}

    override fun readbooks() {
        println("$name is reading")
    }

    override fun doHomeWork() {
        println("$name is doing homework")
    }
}