package com.miu.quizapp

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var total=0

        Submit.setOnClickListener {
            val date=LocalDate.now()
            val dateTime=LocalDateTime.now()
            val day=dateTime.dayOfMonth
            val year=dateTime.year
            val month=dateTime.monthValue
            val hrs=dateTime.hour
            val minute=dateTime.minute
            val sec=dateTime.second
            total=0
            val clicked=radioGroup.checkedRadioButtonId

            total += when(clicked){
                R.id.rb1-> 0
                R.id.rb2-> 50
                R.id.rb3-> 0
                R.id.rb4-> 0
                else->{
                    0
                }
            }
            if(checkbox1.isChecked)total+=0
            if(checkbox2.isChecked)total+=25
            if(checkbox3.isChecked)total+=25
            if(checkbox4.isChecked)total+=0

           val alertBuilder=AlertDialog.Builder(this)
            alertBuilder.setTitle("Result")
            alertBuilder.setMessage("Congratulations You Completed Your Quiz at $year :$month .$day . at " +
                    "$hrs :$minute :$sec UTC Your Quiz score is $total")
            alertBuilder.setIcon(R.drawable.ic_baseline_done_all_24)
            alertBuilder.setPositiveButton("Ok"){dialogInterface,which->
                dialogInterface.dismiss()
            }
            val dialog=alertBuilder.create()
            dialog.show()
        }

        cancel.setOnClickListener {
            radioGroup.clearCheck()
            checkbox1.isChecked=false
            checkbox2.isChecked=false
            checkbox3.isChecked=false
            checkbox4.isChecked=false
        }
    }
}