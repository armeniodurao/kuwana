package com.example.kuwana

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuwana.databinding.ActivityResumoBinding

class ResumoActivity : AppCompatActivity() {

   private lateinit var binding:ActivityResumoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResumoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)

        val numPeople = intent.getIntExtra("numPeople",0)

        val percentage = intent.getIntExtra("percentage",0)

        val totalAmount = intent.getFloatExtra("totalAmount",0.0f)

          binding.tvPercentage.text = percentage.toString()
          binding.tvTotalAmount.text = totalAmount.toString()
          binding.tvTotalTable.text = totalTable.toString()
          binding.tvNumPeopleTable.text = numPeople.toString()

          binding.btnRefresh.setOnClickListener {
              finish()
          }

    }
}