package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculateScore(View view){
        int score = 0;
        /**
         * TextView for displaying score.
         */
        TextView scoreView= (TextView) findViewById(R.id.score_text_view);
        /**
         * Answers for questions one to six.
         * Radio Buttons
         */
        RadioButton ansOne = (RadioButton) findViewById(R.id.one_answer);
        RadioButton ansTwo = (RadioButton) findViewById(R.id.two_answer);
        RadioButton ansThree = (RadioButton) findViewById(R.id.three_answer);
        RadioButton ansFour = (RadioButton) findViewById(R.id.four_answer);
        RadioButton ansFive = (RadioButton) findViewById(R.id.five_answer);
        RadioButton ansSix = (RadioButton) findViewById(R.id.six_answer);
        /**
         * Answers for question seven.
         * CheckBox
         */
        CheckBox ansSevenOne = (CheckBox)findViewById(R.id.seven_answer_one);
        CheckBox ansSevenTwo = (CheckBox)findViewById(R.id.seven_answer_two);
        CheckBox ansSevenThree = (CheckBox)findViewById(R.id.seven_answer_three);
        /**
         * Answers for question eight.
         * CheckBox
         */
        CheckBox ansEightOne = (CheckBox)findViewById(R.id.eight_answer_one);
        CheckBox ansEightTwo = (CheckBox)findViewById(R.id.eight_answer_two);
        CheckBox ansEightThree = (CheckBox)findViewById(R.id.eight_answer_three);
        /**
         * Answers for question nine and ten.
         * EditText
         */
        EditText Nine = (EditText) findViewById(R.id.nine_answer);
        String ansNine = Nine.getText().toString();
        EditText Ten = (EditText) findViewById(R.id.ten_answer);
        String ansTen = Ten.getText().toString();
        Boolean ans[] = {ansOne.isChecked(),ansTwo.isChecked(),ansThree.isChecked(),ansFour.isChecked(),ansFive.isChecked(),ansSix.isChecked()};
        for(int i=0;i<6;i++)
        {
            if(ans[i])
            {
                score++;
            }
        }
        if(ansSevenOne.isChecked() && ansSevenTwo.isChecked() && ansSevenThree.isChecked())
            score++;
        if(ansEightOne.isChecked() && ansEightTwo.isChecked() && ansEightThree.isChecked())
            score++;
        if(ansNine.equals("Param") ||ansNine.equals("param") ||ansNine.equals("PARAM"))
            score++;
        if(ansTen.equals("Internet Protocol") ||ansTen.equals("internet protocol") ||ansTen.equals("Internet protocol") || ansTen.equals("INTERNET PROTOCOL"))
            score++;
        scoreView.setText("You have scored "+Integer.toString(score)+"/10");
    }
}
