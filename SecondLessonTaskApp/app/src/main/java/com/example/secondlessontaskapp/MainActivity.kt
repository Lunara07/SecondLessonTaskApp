package com.example.secondlessontaskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondlessontaskapp.Word
import com.example.secondlessontaskapp.WordAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var wordAdapter: WordAdapter? = null
    private val kaz: List<String> = listOf("А","Ә","Б","В","Г",
                                    "Ғ","Д","Е","Ж",
                                    "З","И","Й","К","Қ",
                                    "Л","М","Н","Ң","О",
                                    "Ө","П","Р","С","Т",
                                    "У","Ұ","Ү","Ф","Х",
                                    "Һ","Ч","Ш",
                                    "Ы","І", "Я","Э","Ю","Ь",
                                    "а","ә","б","в","г",
                                    "ғ","д","е","ж",
                                    "з","и","й","к","қ",
                                    "л","м","н","ң","о",
                                    "ө","п","р","с","т",
                                    "у","ұ","ү","ф","х",
                                    "һ","ч","ш",
                                    "ы","і", "я","э","ю","я",
                                    " ","!","?",".",",")
    private val lat: List<String> = listOf("А","Á","B","V","G",
                                    "Ǵ","D","Е","J",
                                    "Z","I","I","K","Q",
                                    "L","M","N","Ń","О",
                                    "Ó","P","R","S","Т",
                                    "Ý","U","Ú","F","H",
                                    "H","Ch","Sh",
                                    "Y","І", "Ia", "E", "Ýu", "",
                                    "а","á","b","v","g",
                                    "ǵ","d","е","j",
                                    "z","i","i","к","q",
                                    "l","m","n","ń","о",
                                    "ó","p","r","s","t",
                                    "ý","u","ú","f","h",
                                    "h","ch","sh",
                                    "y","і", "ia", "e", "ýu", "",
                                    " ","!","?",".",",")

    lateinit var input: EditText
    lateinit var btn: Button
    lateinit var out: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.inputText)
        btn = findViewById(R.id.buttonTranslate)
        out = findViewById(R.id.outputText)



        btn.setOnClickListener(this)
        setupWordList()

    }
    override fun onClick(v: View?) {
        var name:String = input.text.toString()
        var temp: String = ""
        name.forEach { s: Char ->
            var i = 0
            if (s.toString() != kaz[i]) {
                while (s.toString() != kaz[i]) {
                    i++
                }
                temp += lat[i]
            }else {
                temp += lat[i]
            }
        }
        out.text = temp
        percent(input.text.toString().toLowerCase())

        if(inputText.text.isNotEmpty()) {
            wordAdapter?.addItem(
                Word("${input.text.toString()} - ${out.text.toString()}")
            )
        }


    }

    private fun percent(full: String) {
        var temp: String = ""
        kaz.forEachIndexed { index: Int, s: String ->
            var num = 0
            full.forEach {  it: Char ->
                if (s == it.toString()) {
                    num++
                }
            }
            var perc: Float = ((num.toFloat() / full.length.toFloat()) * 100)
            if (num!= 0) {
                temp += "${kaz.get(index)} - $perc% \n"
            }
        }
        this.textViewKol.text = temp
    }

    private fun setupWordList() {
        wordAdapter = WordAdapter(
            textClickListener = { position ->
                wordAdapter?.removeItem(position)
            }
        )


        val selectPrayerManager = LinearLayoutManager(this)
        wordsRecyclerView.apply {
            layoutManager = selectPrayerManager
            adapter = wordAdapter
        }

        /*wordAdapter?.addItems(
            listOf(
                Word("${input.text} - ${out.text}")
            )
        )*/
    }
}
