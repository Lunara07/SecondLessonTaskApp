package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //First Task
        var numbers: MutableList<Int> = mutableListOf<Int>()
        for (x in 0..9) {
            numbers.add(Random.nextInt(0, 10))
        }
        var temp = ""
        numbers.forEach { element: Int -> temp+= "${element} , " }
        var max = numbers.max()
        var min = numbers.min()
        var avg = numbers.average()

        //Second Task
        var temp2 = ""
        var primeNumbers: MutableList<Int> = mutableListOf<Int>()
        var checker = 0
        for (p in 2..100) {
            if (p == 2) {
                primeNumbers.add(p)
            } else {
                for (k in 2..p) {
                    if (k != p) {
                        if (p % k == 0) {
                            checker = 1
                        }
                    }
                }
                if (checker == 0) {
                    primeNumbers.add(p)
                }
                checker = 0
            }
        }
        primeNumbers.forEach { element2: Int -> temp2+= "${element2} , " }

        //Third Task
        var text = "My name is Lunara Nurgaliyeva. I am a student of Nazarbayev University. My major is Computer Science."
        var lett: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        var temp3 = ""
        var keys: MutableList<Char> = mutableListOf<Char>()
        for (lette in text) {
            if (lette.equals('.')==true|| lette.equals(' ')==true) {
                continue
            }
            else {
                var letter = lette.toLowerCase()
                keys.addAll(lett.keys)
                if (keys.contains(letter)) {
                    if (lett.get(letter) == null) {
                        lett.put(letter, 1)
                    } else {
                        var value = lett.get(letter)!!
                        lett.put(letter, value + 1)
                    }
                } else {
                    lett.put(letter, 1)
                }
            }
        }
        for ((key, vall) in lett) {
            temp3+="${key}: ${vall}, "
        }

        outtextView.text = "First task: \n" + temp + "Max: " + max + " Min: " + min + " Average: "+ avg + "\n" +
                "Second Task:  " + temp2 + "\n" +
                "Thirds Task: " + temp3
    }
}
