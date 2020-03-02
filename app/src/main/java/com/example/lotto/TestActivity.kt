package com.example.lotto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        button.setOnClickListener{
            //메인 엑티비티를 실행하는 intent를 생성
            // 명시적 Intent
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            //intent를 사용하여 액티비티 시장
            startActivity(intent)
        }

        button2.setOnClickListener{
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)

            startActivity(intent)
        }
        button3.setOnClickListener{
            val intent = Intent(this@TestActivity, NameActivity::class.java)

            startActivity(intent)
        }
        button4.setOnClickListener{
            val intent = Intent(this@TestActivity, ResultActivity::class.java)

            startActivity(intent)
        }
    }

    // xml에 메소드 등록, 버튼 onclick에 해당 함수 설정함
    fun goConstellation(view:View){
        val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
        startActivity(intent)
    }

    // 암시적 Intent
    fun callWeb(view: View){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com")))
    }
}
