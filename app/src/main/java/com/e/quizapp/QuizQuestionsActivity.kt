package com.e.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {



    private var mCurrentPosition:Int=1
    // store position of progress bar
    private var mQuestionsList : ArrayList<Question>?=null
    // made an array list of type Question(class we created)
    private var mSelectedOptionPosition:Int=0
    //will store which option we have selected among the four
    private var mCorrectAnswers:Int =0
    //will keep the score to be shown at end
    private var mUsername:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN


        mQuestionsList = Constants.getQuestion()
        //accessing getQuestions of Constants class
        //(As we used object keyword there will be only one object of it that too with name Constants)

        mUsername=intent.getStringExtra(Constants.USER_NAME)
        //retrieving data from particular key

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_sumbit.setOnClickListener(this)

    }
    private fun setQuestion()
    {

        val question= mQuestionsList!![mCurrentPosition-1]
        //assigning the question,options etc from array list but as array list start from 0 therefore doing -1

        defaultOptionsView()   // all options are back to normal appearance

        if(mCurrentPosition==mQuestionsList!!.size)
        {
            btn_sumbit.text="FINISH"
        }
        else{
            btn_sumbit.text="SUBMIT"
        }

        progressbar.progress=mCurrentPosition
        //updating progress bar
        tv_progress.text = "$mCurrentPosition" + "/" + progressbar.max
        //updating textview next to progress bar

        tv_question.text= question!!.question
        //updating question

        iv_image.setImageResource(question.image)
        //updating image

        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
        // updating questions
    }

    private fun defaultOptionsView()               // reseting options to default appearance
    {
        val options = ArrayList<TextView>()
        // making array list of textview
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        // adding to array list


        for(i in options)
        {

            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(this,R.drawable.options_border)
            tv_option_one.setOnClickListener(this)
            tv_option_two.setOnClickListener(this)
            tv_option_three.setOnClickListener(this)
            tv_option_four.setOnClickListener(this)

        }

        //using for loop for changing appearance of every Text View(options)

    }

    override fun onClick(v: View?)
    {
        when(v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            //The views that are defined in these layout files can be accessed in code by referencing their ids
            // from R.java file.The constant R.id.text1 corresponds to the id defined for the TextView
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_sumbit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else-> {
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                }
                else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition,R.drawable.wrong_options_border)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_options_border)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        btn_sumbit.text="FINISH"
                    }
                    else{
                        tv_option_one.setOnClickListener(null)
                        tv_option_two.setOnClickListener(null)
                        tv_option_three.setOnClickListener(null)
                        tv_option_four.setOnClickListener(null)
                        btn_sumbit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }

        //whichever text view is presses will run the function selectedOptionView with
        // their particular parameter passed


    }


    private fun answerView(answer:Int,mydrawable:Int) {
        // mydrawable is int because image are assigned an int value
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, mydrawable)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, mydrawable)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, mydrawable)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this, mydrawable)
            }
        }

    }


    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum


        tv.setTextColor(Color.parseColor("#363A43"))
        //color is the class and parseColor is nested class used to
        // assign color (without hardcoding I guess)

        tv.setTypeface(tv.typeface,Typeface.BOLD )
        //for changing textStyle

        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_options_border)

    }

}
