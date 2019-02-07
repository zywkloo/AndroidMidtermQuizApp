package com.comp1601.truefalsequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayResultActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName() + " @" + System.identityHashCode(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        int message = intent.getIntExtra("Grade",-1);
        if (message == -1) {
            Log.i(TAG,"Intent data corrupted");
        } else{
           //Capture result title
            TextView textGradeTitle = findViewById(R.id.your_grade_title);
            textGradeTitle.setTextSize(30); //设置45SP

            // Capture the layout's TextView and set the grade_result as its text
            Transcript transcript= new Transcript(message);
            TextView textGradeRet = findViewById(R.id.grade_result);

            textGradeRet.setTextSize(40); //设置45SP
            textGradeRet.setText(transcript.getGradeText());

            // Capture the layout's TextView and set the comment as its text
            TextView textGradeComment = findViewById(R.id.grade_comment);
            textGradeComment.setTextSize(30);
            textGradeComment.setText(transcript.getComment());
        }


    }
}
