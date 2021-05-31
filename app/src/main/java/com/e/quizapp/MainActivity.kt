package com.e.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //AppCompatActivity() : Base class for activities that wish to use some of the
    // newer platform features on older Android devices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        // for hiding status bar


        btn_start.setOnClickListener {
            if(et_name.text.toString().isEmpty())
            {
                Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                //Intent is the function here or class and intent is variable or object
                // and its parameter is from which activity to which ie from current activity(this) to mentioned

                intent.putExtra(Constants.USER_NAME,et_name.text.toString())
                // sending username i.e. et_name.text to next activity
                // and doing so with intent.putExtra() ; its 1st parameter is called a KEY reqd for sending and retrieving data
                // and we can retrieve this info in onCreate of mentioned activity

                startActivity(intent)
                finish()   //this closes current activity
            }
        }
    }
}
