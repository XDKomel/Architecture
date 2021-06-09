package com.camille.architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    lateinit var result: TextView
    lateinit var personName: EditText
    lateinit var age: EditText
    lateinit var seekBar: SeekBar
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        result = findViewById(R.id.result)
        personName = findViewById(R.id.personName)
        age = findViewById(R.id.age)
        seekBar = findViewById(R.id.seekBar)

        val presenter = Presenter(
            personName.text.toString(),
            try { age.text.toString().toInt() } catch (e: NumberFormatException) { 0 },
            seekBar.progress
        )

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                presenter.updateProgress(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        button.setOnClickListener { result.text = presenter.parseData() }
    }
}