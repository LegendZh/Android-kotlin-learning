package com.example.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputText=load()
        if(inputText.isNotEmpty()){
            editText.setText(inputText)
            editText.setSelection(inputText.length)
            Toast.makeText(this,"Restoring succeeded", Toast.LENGTH_SHORT).show()
        }
    }
    //保存文件
    override fun onDestroy() {
        super.onDestroy()
        val inputText=editText.text.toString()
        Log.d("onDestroy","Save into file $inputText")
        save(inputText)
    }

    private fun save(inputText:String){
        try {
            val output=openFileOutput("data",Context.MODE_PRIVATE)
            val writer=BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
            }
        }
        catch (e:IOException){
            e.printStackTrace()
        }
    }
    //存储文件
    private fun load():String{
        val content=StringBuilder()
        try {
            val input=openFileInput("data")
            val reader=BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        }catch (e:IOException){
            e.printStackTrace()
        }
        return content.toString()
    }
}