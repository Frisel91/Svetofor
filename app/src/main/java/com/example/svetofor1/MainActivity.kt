package com.example.svetofor1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    var imSvetofor: ImageView? = null
    var imageArray: IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)
    var counter = 0
    var timer:Timer? = null
    var is_run = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imSvetofor = findViewById(R.id.imageView)
    }
    fun onStartStop(view: View){
        view as ImageButton
        if (!is_run){

            startStop()
            view.setImageResource(R.drawable.button_stop)
            is_run = true

        }
        else{
            imSvetofor?.setImageResource((R.drawable.semafor_grey))
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            is_run = false
            counter = 0
        }

    }

    fun startStop(){
        timer = Timer()
        timer?.schedule(object :TimerTask(){
            override fun run() {
                runOnUiThread {
                    imSvetofor?.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }

            }

        }, 0,1000)
    }
}


