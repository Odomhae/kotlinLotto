package com.example.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "main입니다", Toast.LENGTH_LONG).show()

        //랜덤번호 카드
        randomCard.setOnClickListener{
            //인텐트만들고 startActivity로 실행
            //startActivity(Intent(this, ResultActivity::class.java))
            val intent = Intent(this, ResultActivity::class.java)

            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
           // intent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()))
            startActivity(intent)
        }

        //별자리
        constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        //이름
        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }

}
