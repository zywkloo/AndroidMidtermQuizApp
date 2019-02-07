package com.comp1601.truefalsequiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "Grade";    //an extra-info key of sending data to result Activity
    private static Integer countOfRightAnswers = 0; //countOfRightAnswers

    private final String TAG = this.getClass().getSimpleName() + " @" + System.identityHashCode(this);
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mEButton;
    private Button mPrevButton;
    private Button mSubmitButton;
    private Button mNextButton;

    private ArrayList<Question> mQuestions = new ArrayList() ;
    private ArrayList<Choice> mChoices = new ArrayList() ;
    private static ArrayList<String> mAnswers = new ArrayList(Collections.nCopies(10, new String("unanswered"))) ;
    private static ArrayList<Integer> mGrade = new ArrayList(Collections.nCopies(10, new Integer(0))) ;



    private  TextView mQuestionTextView;
    private  TextView mChoiceTextView;
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

    private void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE, (int)countOfRightAnswers);
        startActivity(intent);
        this.finish();
    }


    private void checkButtonsBackground(){
        mAButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_test,null));
        mBButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_test,null));
        mCButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_test,null));
        mDButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_test,null));
        mEButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_test,null));
        switch (mAnswers.get(mCurrentQuestionIndex)) {
            case "A":
                mAButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_selected,null));
                break;
            case "B":
                mBButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_selected,null));
                break;
            case "C":
                mCButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_selected,null));
                break;
            case "D":
                mDButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_selected,null));
                break;
            case "E":
                mEButton.setBackground(this.getResources().getDrawable(R.drawable.shape_button_selected,null));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, getDeviceInfo());
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate(Bundle)");
        setContentView(R.layout.activity_main);
        //reset count Of Right Answers counting
        countOfRightAnswers=0;

        mAButton= findViewById(R.id.A_button);
        mBButton= findViewById(R.id.B_button);
        mCButton= findViewById(R.id.C_button);
        mDButton= findViewById(R.id.D_button);
        mEButton= findViewById(R.id.E_button);

        mPrevButton= findViewById(R.id.Prev_button);
        mNextButton= findViewById(R.id.Next_button);
        mSubmitButton= findViewById(R.id.Submit_button);

        //push all Questions.
        mQuestions.add(new Question(getString(R.string.question1)));
        mQuestions.add(new Question(getString(R.string.question2)));
        mQuestions.add(new Question(getString(R.string.question3)));
        mQuestions.add(new Question(getString(R.string.question4)));
        mQuestions.add(new Question(getString(R.string.question5)));
        mQuestions.add(new Question(getString(R.string.question6)));
        mQuestions.add(new Question(getString(R.string.question7)));
        mQuestions.add(new Question(getString(R.string.question8)));
        mQuestions.add(new Question(getString(R.string.question9)));
        mQuestions.add(new Question(getString(R.string.question10)));

        //push all Choices.
        mChoices.add(new Choice(getString(R.string.choice1)));
        mChoices.add(new Choice(getString(R.string.choice2)));
        mChoices.add(new Choice(getString(R.string.choice3)));
        mChoices.add(new Choice(getString(R.string.choice4)));
        mChoices.add(new Choice(getString(R.string.choice5)));
        mChoices.add(new Choice(getString(R.string.choice6)));
        mChoices.add(new Choice(getString(R.string.choice7)));
        mChoices.add(new Choice(getString(R.string.choice8)));
        mChoices.add(new Choice(getString(R.string.choice9)));
        mChoices.add(new Choice(getString(R.string.choice10)));

        mQuestionTextView=(TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());

        mChoiceTextView=(TextView) findViewById(R.id.choice_text_view);
        mChoiceTextView.setText(mChoices.get(mCurrentQuestionIndex).getChoice());

        //5 click listener for 5 button respectively
        mAButton.setOnClickListener(v->{
                Log.i(TAG,"A Button Clicked");
                mAnswers.set(mCurrentQuestionIndex,"A");
                checkButtonsBackground();
                if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("A")) {
                    mGrade.set(mCurrentQuestionIndex,1);
                } else {
                    mGrade.set(mCurrentQuestionIndex,0);
                }
        });

        mBButton.setOnClickListener(v-> {
            Log.i(TAG,"B Button Clicked");
            mAnswers.set(mCurrentQuestionIndex,"B");
            checkButtonsBackground();
            if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("B")) {
                mGrade.set(mCurrentQuestionIndex,1);
            } else {
                mGrade.set(mCurrentQuestionIndex,0);
            }
        });

        mCButton.setOnClickListener(v-> {
            Log.i(TAG,"C Button Clicked");
            mAnswers.set(mCurrentQuestionIndex,"C");
            checkButtonsBackground();
            if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("C")) {
                mGrade.set(mCurrentQuestionIndex,1);
            } else {
                mGrade.set(mCurrentQuestionIndex,0);
            }
        });

        mDButton.setOnClickListener(v-> {
            Log.i(TAG,"D Button Clicked");
            mAnswers.set(mCurrentQuestionIndex,"D");
            checkButtonsBackground();
            if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("D")) {
                mGrade.set(mCurrentQuestionIndex,1);
            } else {
                mGrade.set(mCurrentQuestionIndex,0);
            }
        });
        mEButton.setOnClickListener(v-> {
            Log.i(TAG,"E Button Clicked");
            mAnswers.set(mCurrentQuestionIndex,"E");
            checkButtonsBackground();
            if (mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("E")) {
                mGrade.set(mCurrentQuestionIndex,1);
            } else {
                mGrade.set(mCurrentQuestionIndex,0);
            }
        });


        //next button handler
        mNextButton.setOnClickListener(v-> {
            Log.i(TAG, "Next Button Clicked");
            if (mCurrentQuestionIndex >= mQuestions.size()-1) {
                //warn the end of quiz
                Toast.makeText(MainActivity.this,
                        R.string.No_Next_label,
                        Toast.LENGTH_SHORT).show();
                mCurrentQuestionIndex = (mQuestions.size()-1);
            } else{
                //renew 2 text views
                mCurrentQuestionIndex++;
                mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                mChoiceTextView.setText(mChoices.get(mCurrentQuestionIndex).getChoice());
            };
            checkButtonsBackground();
        });


        //prev button handler
        mPrevButton.setOnClickListener(v-> {
            Log.i(TAG,"Prev Button Clicked");
            if (mCurrentQuestionIndex <= 0) {
                Toast.makeText(MainActivity.this,
                        R.string.No_Prev_label,
                        Toast.LENGTH_SHORT).show();
                mCurrentQuestionIndex =0;
            } else{
                mCurrentQuestionIndex--;
                mQuestionTextView.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                mChoiceTextView.setText(mChoices.get(mCurrentQuestionIndex).getChoice());
            };
            checkButtonsBackground();
        });
        //submission handler,ajoshangjixie
        mSubmitButton.setOnClickListener(v-> {
            Log.i(TAG,"Submit Button Clicked");
            checkButtonsBackground();
            //count the new sum numbers,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
            for (int i = 0 ;i<mAnswers.size();i++){
                if (mGrade.get(i).equals(1)){
                    countOfRightAnswers++;
                }
            }
            sendMessage(v);
        });

    }
    //Start log
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "onStart()") ;
    }
    //Resume log
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "onResume()") ;
    }
    //Pause log
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause()") ;
    }
    //Stop log
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "onStop()") ;
    }

    //Destroy log
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy()") ;
    }
}


















































































































































































































































































































































































































