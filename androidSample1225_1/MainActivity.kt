package com.kyle.sample1225_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var button1 = findViewById<Button>(R.id.btn1)
        var button1 = findViewById<View>(R.id.btn1) as Button

        button1.setOnClickListener{

            var likeArray = arrayOf("하입보이", "사건의 지평선", "좋은날")
            var checkArray = booleanArrayOf(true, false, false) // boolean 배열로 생성된다.
            var dlg = AlertDialog.Builder(this@MainActivity) // 팝업창 같은 유형
                .setTitle("좋아하는 노래는?")
                .setIcon(R.mipmap.ic_launcher)
                .setMultiChoiceItems(likeArray, checkArray){ dialog, which, isChecked ->
                    button1.text = likeArray[which]
                }
                .setPositiveButton("닫기", null)
            .show()
        }
    }
}