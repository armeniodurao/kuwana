package com.example.kuwana

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.kuwana.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {   



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0


          binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
              if(isChecked){
                  percentage = 10
              }
          }

          binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
              if(isChecked){
                  percentage = 15
              }
          }

          binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
              if(isChecked){
                  percentage = 20
              }
          }

         val adapter = ArrayAdapter.createFromResource(
             this,
             R.array.num_people,
             android.R.layout.simple_spinner_item
         )
           adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
           binding.spinnerNumberOfPeople.adapter = adapter

           var numOfPeopleSelected = 0
           binding.spinnerNumberOfPeople.onItemSelectedListener =
             object : AdapterView.OnItemSelectedListener {

                 override fun onItemSelected(
                     parent: AdapterView<*>?,
                     view: View?,
                     position: Int,
                     id: Long,
                 ) {
                     numOfPeopleSelected = position
                 }

                 override fun onNothingSelected(parent: AdapterView<*>?) {

                 }

             }

         binding.btnDone.setOnClickListener {
             val totalTableTemp = binding.tieTotal.text

             if (totalTableTemp?.isEmpty() == true
                 )  {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
             } else {
                 val totalTable: Float = totalTableTemp.toString().toFloat()
                 val nPeople: Int = numOfPeopleSelected

                 val totaltemp = totalTable / nPeople
                 val tips = totaltemp * percentage / 100
                 val totalWithTips = totaltemp + tips

                 val intent = Intent(this, ResumoActivity::class.java)

                 intent.apply {
                     putExtra( "totalTable",totalTable)
                     putExtra( "numPeople", numOfPeopleSelected)
                     putExtra( "percentage", percentage)
                     putExtra( "totalAmount",totalWithTips)
                 }
                    clean()
                 startActivity(intent)
                  }
             }

           binding.btnClean.setOnClickListener {
             clean()
           }


         }

    private fun clean(){
        binding.tieTotal.setText("")
        binding.rbOptionOne.isChecked = false
        binding.rbOptionTwo.isChecked = false
        binding.rbOptionThree.isChecked = false
    }

}









