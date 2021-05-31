package com.e.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN


        val username =intent.getStringExtra(Constants.USER_NAME)
        tv_name.text=username

        val totalquestion =intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctans =intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        //when using intent to get int value it shows error,
        // for that we have to pass default value also in case no no is recieved
        tv_score.text="Your score is $correctans/$totalquestion"

        btn_finish.setOnClickListener{
            /*val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)*/
            // could do like this or like shown
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }


    }
}
