package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button =findViewById(R.id.button)
        val editText:EditText=findViewById(R.id.editText)
        button.setOnClickListener {
            //在这里实现我们想要实现的逻辑
            //val inputText=editText.text.toString()
            //Toast.makeText(this,inputText,Toast.LENGTH_SHORT).show()
            //val imageView:ImageView=findViewById(R.id.imageView)
            //imageView.setImageResource(R.drawable.img_2)
            //进度条相关代码
            //val progressBar:ProgressBar=findViewById(R.id.progressBar)
            /*if(progressBar.visibility==View.VISIBLE) {
                progressBar.visibility = View.GONE
            }else{
                progressBar.visibility=View.VISIBLE
            }*/
            //progressBar.progress+=10
            //建立提醒框
            AlertDialog.Builder(this).apply {
                setTitle("This is Dialog")
                setMessage("Something important.")
                setCancelable(false)
                setPositiveButton("OK") {
                    dialog, which ->
                }
                setNegativeButton("Cancel") { dialog, which ->
                }
                show()

            }
        }
    }


}