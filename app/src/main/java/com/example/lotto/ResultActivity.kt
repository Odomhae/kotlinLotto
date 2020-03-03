package com.example.lotto

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    val lottoImageStartId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //Toast.makeText(applicationContext, "result입니다", Toast.LENGTH_LONG).show()

        //전달받은 결과 배열
        val result = intent.getIntegerArrayListExtra("result")

        // 전달받은 이름
        val name = intent.getStringExtra("name")

        // 전달받은 별자리
        val constellation = intent.getStringExtra("constellation")

        // 결과화면 기본 텍스트
        resultLabel.text = "랜덤으로 생성된 \n로또번호입니다."

        // 이름이 전달된 경우
        if(!TextUtils.isEmpty(name))
            resultLabel.text = "${name}님의 \n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또번호입니다"

        // 별자리가 전달된 경우
        if(!TextUtils.isEmpty(constellation))
            resultLabel.text = "${constellation}님의 \n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또번호입니다"


        //결과있으면 공이미지 업데이트
        result?.let{
            //정렬
            updateLottoBallImg(result.sortedBy { it })
        }
    }

    fun updateLottoBallImg(result : List<Int>){

        if(result.size< 6)
            return

        // 번호 1나오면 startId가 1부터니까 0을 더해야함
        // 이런식으로 ..
        imageView1.setImageResource(lottoImageStartId+ (result[0]- 1))
        imageView2.setImageResource(lottoImageStartId+ (result[1]- 1))
        imageView3.setImageResource(lottoImageStartId+ (result[2]- 1))
        imageView4.setImageResource(lottoImageStartId+ (result[3]- 1))
        imageView5.setImageResource(lottoImageStartId+ (result[4]- 1))
        imageView6.setImageResource(lottoImageStartId+ (result[5]- 1))
    }
}
