package com.example.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val msgList=ArrayList<Msg>()
    private var adapter:MsgAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsg()
        val layoutManager=LinearLayoutManager(this)
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        val send:Button=findViewById(R.id.send)
        recyclerView.layoutManager=layoutManager
        adapter=MsgAdapter(msgList)
        recyclerView.adapter=adapter
        send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        val send:Button=findViewById(R.id.send)
        val inputText:EditText=findViewById(R.id.inputText)
        when(v){
            send->{
                val content=inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg=Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size-1) //当有新消息时，刷新RecyclerView的显示
                    recyclerView.scrollToPosition(msgList.size-1) //将RecyclerView定义到最后一行
                    inputText.setText("") //清空输入框中的内容
                }
            }
        }
    }
    //初始化我们刚开始的消息
    private fun initMsg(){
        val msg1=Msg("喂喂喂",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2=Msg("哈哈哈",Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3=Msg("阿巴阿巴",Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}