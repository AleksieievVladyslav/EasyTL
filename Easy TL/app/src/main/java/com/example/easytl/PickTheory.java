package com.example.easytl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PickTheory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_theory);
    }
    public void backBut(View view){
        Intent intent = new Intent(PickTheory.this, EasyTL.class);
        startActivity(intent);
    }

    private void chooseTopic(View view, int topicNum){
        Intent intent = new Intent(PickTheory.this, Theory.class);
        intent.putExtra("topicNum", topicNum);
        startActivity(intent);
    }

    public void topicClick_1 (View view) {
        chooseTopic(view, 0);
    }
}
