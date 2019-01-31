package com.comp1601.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mYesButton;
    private Button mNoButton;
    private ArrayList<Question> mQuestions = new ArrayList() ;
    private  TextView mQuestionTextView;
    private int mCurrentQuestionIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mYesButton= findViewById(R.id.yes_button);
        mNoButton= findViewById(R.id.no_button);

        mQuestions.add(new Question(getString(R.string.question1)));
        mQuestions.add(new Question(getString(R.string.question2)));
        mQuestions.add(new Question(getString(R.string.question3)));
        mQuestions.add(new Question(getString(R.string.question4)));
        mQuestions.add(new Question(getString(R.string.question5)));

        mQuestionTextView=(TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());


        mYesButton.setOnClickListener(v->{
                if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("Yes")) {
                    Toast.makeText(MainActivity.this,
                            R.string.correct_answer_toast,
                            Toast.LENGTH_SHORT).show();
                    mCurrentQuestionIndex++;
                    if (mCurrentQuestionIndex >= mQuestions.size()) mCurrentQuestionIndex = 0;
                    mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                } else {
                    Toast.makeText(MainActivity.this,
                            R.string.wrong_answer_toast,
                            Toast.LENGTH_SHORT).show();

                }
        });

        mNoButton.setOnClickListener(v-> {
                if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("No")) {
                    Toast.makeText(MainActivity.this,
                            R.string.correct_answer_toast,
                            Toast.LENGTH_SHORT).show();
                    mCurrentQuestionIndex++;
                    if (mCurrentQuestionIndex >= mQuestions.size()) mCurrentQuestionIndex = 0;
                    mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                } else {
                    Toast.makeText(MainActivity.this,
                            R.string.wrong_answer_toast,
                            Toast.LENGTH_SHORT).show();

                }
        });

    }
}
