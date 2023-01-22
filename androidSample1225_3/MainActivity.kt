package com.kyle.sample1225_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnWrite : Button = findViewById(R.id.btnWrite)
        var btnRead : Button = findViewById(R.id.btnRead)

        btnWrite.setOnClickListener {
            var outFs : FileOutputStream = openFileOutput("file.txt", Context.MODE_PRIVATE)
            var str = "처음하는 코틀린 안드로이드 파일 입출력"
            outFs.write(str.toByteArray()) // 문자열을 byte[]형으로 변경
            outFs.close()
            Toast.makeText(applicationContext, "파일이 생성됨", Toast.LENGTH_SHORT).show()
        }

        btnRead.setOnClickListener {
            try{
                var inFs : FileInputStream = openFileInput("file.txt")
                var txt = ByteArray(30)
                inFs.read(txt)
                var str = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
                inFs.close()
            } catch (e : IOException){
                Toast.makeText(applicationContext, "파일이 존재하지 않음", Toast.LENGTH_SHORT).show()
            }
        }
    }
}