package com.example.lotto

import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

object LottoNumberMaker {


    //랜덤번호 생성
    // 1부터 45까지
    fun getRandomLottoNumber() : Int{
        return Random.nextInt(45) + 1 // 괄호 없어도 되나??
    }

    /**
     * 랜덤으로 6개의 로또번호 만드는 함수
     */
    fun getRandomLottoNumbers() : MutableList<Int>{
        //번호 저장할 리스트
        val lottoNumbers = mutableListOf<Int>()

        //6번 반복
        repeat(6){ //for(i in 1..6){
            var num = 0

            do{
                num = getRandomLottoNumber()
                print("num :${num}, ")
                //중복제거
            }while (lottoNumbers.contains(num))

            println(num)
            lottoNumbers.add(num)
        }

        println("lottonum배열 : ${lottoNumbers}")
        return lottoNumbers
    }

    //셔플버전
    fun getShuffleLottoNumbers() : MutableList<Int>{
        val list = mutableListOf<Int>()

        for(num in 1..45)
            list.add(num)

        //무작위로 섞는다
        list.shuffle()

        // 앞에서부터 6개 반환
        return list.subList(0,6)
    }

    // 입력받은 이름에 대한 해시코드를 사용하여 로또번호 섞고 결과 반환
    fun getLottoNumbersFromHash(name:String) :MutableList<Int>{
        val list = mutableListOf<Int>()

        for(i in 1..45)
            list.add(i)

        // 현재 date를 yyyy-mm-dd형식으로 받고 이름까지 뒤에 붙여 문자열을 만든다
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

        //Random(SEED)를 기준으로 list를 섞는다
        //SEED값은 전달받은 이름과 날짜합친 문자열을 해시코드를 사용
        list.shuffle(Random(targetString.hashCode().toLong()))

        //앞에서부터 6개
        return list.subList(0,6)
    }

}