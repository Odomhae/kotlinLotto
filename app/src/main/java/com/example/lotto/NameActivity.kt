package com.example.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        Toast.makeText(applicationContext, "name입니다", Toast.LENGTH_LONG).show()

        //go 버튼 누르면
        goButton.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }

        //뒤로가기 버튼
        backButton.setOnClickListener {
            //액티비티 종료
            finish()
        }
    }
}
