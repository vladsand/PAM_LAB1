package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Exception
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var height : TextView
    private lateinit var weight : TextView
    private lateinit var result_field : TextView
    private lateinit var button_action : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        height = findViewById(R.id.height_id)
        weight = findViewById(R.id.weight_id)
        result_field = findViewById(R.id.result_text_id)
        button_action = findViewById(R.id.button_calc_id)

        button_action.setOnClickListener()
        {
            var check_height : Double? = null
            var check_weight : Double? = null

            try
            {
              check_height=height.text.toString().toDouble()
                check_weight=weight.text.toString().toDouble()
                if (check_height != null && check_weight != null )
                {
                    var BMI : Double = (check_weight/check_height.pow(2)) * 10000
                    if (BMI < 18.5)
                    {
                        result_field.text = String.format("%.2f", BMI) + "\nUnderweight"
                    }
                    else if (BMI >= 18.5 && BMI < 25)
                    {
                        result_field.text = String.format("%.2f", BMI) + "\nHealthy, normal weight"
                    }
                    else if (BMI >= 25 && BMI < 30)
                    {
                        result_field.text = String.format("%.2f", BMI) + "\nOverweight, hit the gym"
                    }
                    else
                    {
                        result_field.text = String.format("%.2f", BMI) + "\nFat af, hit the gym"
                    }
                }
            }
            catch (e : Exception)
            {
                result_field.text = "Fill both metrics"
                print(e.toString())
            }
        }

    }
}