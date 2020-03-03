package com.example.lotto

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
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
            // 이름 입력하지 않았으면 결과로 안 넘어감
            if(TextUtils.isEmpty(editText.text.toString()))
            {
                Toast.makeText(applicationContext,"이름을 입력하세요", Toast.LENGTH_LONG).show()
                print("왜 ${editText.text.toString()}")
                return@setOnClickListener

            }

            //startActivity(Intent(this, ResultActivity::class.java))
            val intent = Intent(this, ResultActivity::class.java)

            // 이름과 날짜에 해당하는 번호들
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString())))
            // 입력받은 이름도 추가로 전달
            intent.putExtra("name", editText.text.toString())

            startActivity(intent)
        }

        //뒤로가기 버튼
        backButton.setOnClickListener {
            //액티비티 종료
            finish()
        }
    }

}
