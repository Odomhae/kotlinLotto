package com.example.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_constellation.*

class ConstellationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)
        Toast.makeText(applicationContext, "consteellation입니다", Toast.LENGTH_LONG).show()

        //번호 확인 버튼 리스너
        goResultButton.setOnClickListener{
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }
}
