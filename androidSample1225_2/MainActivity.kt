package com.kyle.sample1225_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var txtName: TextView
    lateinit var txtEmail : TextView
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEmail : EditText
    lateinit var dialogView : View
    lateinit var toastText : TextView
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtName = findViewById(R.id.txtName)
        txtEmail = findViewById(R.id.txtEmail)
        button1 = findViewById(R.id.button1)

        button1.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog, null) // inflate()는 activity에 올라간다.

            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("정보 입력 하기")
            dlg.setView(dialogView)
            dlg.setPositiveButton("확인"){ dialog, which ->
                dlgEdtName = dialogView.findViewById(R.id.dlgEdt1)
                dlgEmail = dialogView.findViewById(R.id.dlgEdt2)
                txtName.text = dlgEdtName.text.toString()
                txtEmail.text = dlgEmail.text.toString()
            }
            dlg.setNegativeButton("취소"){ dialog, which ->
                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast1, null)
                toastText = toastView.findViewById(R.id.toastText1)
                toastText.text = "취소되었습니다."
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }
    }
}