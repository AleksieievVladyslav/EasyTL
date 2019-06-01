package com.example.easytl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.VideoView;

public class TheoryQuestion  extends AppCompatActivity {

    int topicNumber;
    int questionNumber;
    Question question;
    WebView gifochkaWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_question);

        topicNumber = getIntent().getIntExtra("topicNum", 0);
        questionNumber = getIntent().getIntExtra("questionNum", 0);


        TextView questionTV =  (TextView) findViewById(R.id.questionTextView);
        RadioButton answerRB1 = (RadioButton) findViewById(R.id.answerRadioButton1);
        RadioButton answerRB2 = (RadioButton) findViewById(R.id.answerRadioButton2);
        gifochkaWV = (WebView) findViewById(R.id.gifochkaWebView);

        question = new Question(topicNumber, questionNumber);
        questionTV.setText(question.getQuestionStatement());
        answerRB1.setText(question.getAnswer(0));
        answerRB2.setText(question.getAnswer(1));
        gifochkaWV.loadUrl("file:///android_asset/gifochka.html");
    }

    public void answerRBclick_0(View view) {
        if (question.indexOfCorrectAnswer() == 0) {
            trueAnswer();
        } else {
            falseAnswer();
        }
    }

    public void answerRBclick_1(View view) {
        if (question.indexOfCorrectAnswer() == 1) {
            trueAnswer();
        } else {
            falseAnswer();
        }
    }

    public void trueAnswer() {
        gifochkaWV.loadUrl("file:///android_asset/gifochkaT.html");
    }

    public void falseAnswer() {
        gifochkaWV.loadUrl("file:///android_asset/gifochkaF.html");
    }

    public void backBut(View view){
        Intent intent = new Intent(view.getContext(), Theory.class);
        intent.putExtra("topicNum", topicNumber);
        startActivity(intent);
    }

    public void nextBut (View view) {
        int questionNum = 0;
        Intent intent = new Intent(view.getContext(), TheoryQuestion.class);
        intent.putExtra("topicNum", topicNumber);
        intent.putExtra("questionNum", questionNum);
        startActivity(intent);
    }

}