package com.e.quizapp
//get question function return an array list
object Constants {

    const val USER_NAME:String="User_name"
    const val TOTAL_QUESTIONS:String="Total questions"
    const val CORRECT_ANSWERS:String="Correct ans"
    // made a function to return question list to whoever accesses
    fun getQuestion():ArrayList<Question>
    {
        val questionsList=ArrayList<Question>()

        // 1       making object of Question class
        val que1 = Question(
            1, "The currency of Sweden is ",
            R.drawable.ic_swedishcurrency,
            "Mark","Franc",
            "Lira", "Krona",
            4
        )

        questionsList.add(que1)
            //adding it to array list of type Question


        val que2 = Question(
            2, "Fathometer is used to measure ",
            R.drawable.ic_fathometer,"Rainfall",
                    "Ocean depth",
                    "Sound intensity",
                    "Earthquakes",
                     2
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "Who surpassed Jeff Bezos to become richest person in the world?",
            R.drawable.ic_elon_musk,
            "Bill Gates ", "Elon Musk",
            "Mark Zuckerberg ", "Warren Buffet ", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "Grand Central Terminal, Park Avenue, New York is the world’s",
            R.drawable.ic_grandcentral,
            "highest railway station", "longest railway station",
            "largest railway station", "None of the above", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "The total number of Judges of the International Court of Justice is",
            R.drawable.ic_judges,
            "10", "12",
            "15", "18", 3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "Which company is nicknamed \"Big Blue\"? ",
            0,
            "IBM", "Microsoft ",
            "Apple ", "Twitter", 1
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "The national flag was adopted by the Constituent Assembly of India on",
            R.drawable.ic_flag_of_india,
            "August 15, 1947", "July 22, 1947",
            "January 26, 1950","January 2, 1950",
            2
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Which country broke the gabba test streak of Australia ?",
            R.drawable.ic_indian_team,
            "New Zealand", "India",
            "England", "South Africa", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Who is the sculptor of STATUE OF UNITY , the tallest statue in world ?",
            R.drawable.ic_statue_of_unity,
            "Sankho Chaudhuri", "Ram V. Sutar",
            "Ramkinkar Baij", "None of the above", 2
        )

        questionsList.add(que10)

        return questionsList /// function getQuestion will return the arraylist

        //so 10 objects are created and a array list of it called questionslist is created

    }
}