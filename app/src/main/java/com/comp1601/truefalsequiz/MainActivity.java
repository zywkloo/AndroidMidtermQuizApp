package com.comp1601.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private  final String TAG = this.getClass().getSimpleName() + " @" + System.identityHashCode(this);;
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mEButton;
    private ArrayList<Question> mQuestions = new ArrayList() ;
    private  TextView mQuestionTextView;
    private int mCurrentQuestionIndex = 0;
    private String getDeviceInfo(){
        String s="Device info:";
        try{
            s+= "\n OS Version:" + System.getProperty("os.version")+
                    "("+Build.VERSION.INCREMENTAL + ")";
            s+="\n OS API Level:"  + Build.VERSION.SDK_INT;
            s+="\n Device:" + Build.DEVICE;
            s+="\n Model (and Product):" + Build.MODEL +
                    "("+ Build.PRODUCT+")";
            s+="\n RELEASE:" + Build.VERSION.RELEASE ;
            s+="\n BRAND:" + Build.BRAND ;
            s+="\n DISPLAY:" + Build.DISPLAY;
            s+="\n HARDWARE:" + Build.HARDWARE;
            s+="\n Build ID:"+ Build.ID;
            s+="\n MANUFACTURER:"+ Build.MANUFACTURER;
            s+="\n USER:" + Build.USER;
            s+="\n HOST:" + Build.HOST;

        } catch (Exception e){
            Log.e(TAG,"Error getting Device INFO");
        }
        return s;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getDeviceInfo());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAButton= findViewById(R.id.A_button);
        mBButton= findViewById(R.id.B_button);
        mCButton= findViewById(R.id.C_button);
        mDButton= findViewById(R.id.D_button);
        mEButton= findViewById(R.id.E_button);

        mQuestions.add(new Question(getString(R.string.question1)));
        mQuestions.add(new Question(getString(R.string.question2)));
        mQuestions.add(new Question(getString(R.string.question3)));
        mQuestions.add(new Question(getString(R.string.question4)));
        mQuestions.add(new Question(getString(R.string.question5)));

        mQuestionTextView=(TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());


        mAButton.setOnClickListener(v->{
                Log.i(TAG,"A Button Clicked");
                if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("A")) {
//                    Toast.makeText(MainActivity.this,
//                            R.string.correct_answer_toast,
//                            Toast.LENGTH_SHORT).show();
                    mCurrentQuestionIndex++;
                    if (mCurrentQuestionIndex >= mQuestions.size()) mCurrentQuestionIndex = 0;
                    mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                } else {
                    Toast.makeText(MainActivity.this,
                            R.string.wrong_answer_toast,
                            Toast.LENGTH_SHORT).show();

                }
        });

        mBButton.setOnClickListener(v-> {
                Log.i(TAG,"B Button Clicked");
                if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("B")) {
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

        mCButton.setOnClickListener(v-> {
            Log.i(TAG,"C Button Clicked");
            if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("C")) {
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
        mDButton.setOnClickListener(v-> {
            Log.i(TAG,"D Button Clicked");
            if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("D")) {
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
        mEButton.setOnClickListener(v-> {
            Log.i(TAG,"E Button Clicked");
            if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("E")) {
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
