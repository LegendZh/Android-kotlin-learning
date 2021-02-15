package com.example.uibestpractice

//定义消息的实体类
class Msg (val content:String,val type:Int){
    companion object{
        const val TYPE_RECEIVED=0
        const val TYPE_SENT=1
    }
}