package com.main.lynkbrave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        generate_button.setOnClickListener {
            if(txtNumber.text.toString() == "") {
                Log.d(TAG, "can't be empty")
            }else {
                val i = txtNumber.text.toString().toIntOrNull()
                fibonnacciList(i)
            }
        }

    }

    private fun fibonnacciList(n : Int?): ArrayList<Int> {

        val numList = ArrayList<Int>()
        val list2 = ArrayList<Int>()

        list2.add(1)
        list2.add(89)
        list2.add(7)
        list2.add(40)
        list2.add(0)
        list2.add(7)
        list2.add(8)
        list2.add(34)
        list2.add(21)
        list2.add(55)
        list2.add(91)
        list2.add(100)
        list2.add(24)
        list2.add(28)
        list2.add(103)
        list2.add(144)

        var a = 0
        var b = 1
        var c = 0



        while (c < n!!) {
            c = a + b
            a = b
            b = c
            numList.add(c)
        }

        numList.removeAll(list2)

        Log.d(TAG, "MainActivity: $numList")

        val filteredListStr = String.format(getString(R.string.Filterd_list), numList.toString())
        filtered_list.setText(filteredListStr)

        return numList
    }
}
