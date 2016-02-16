package com.morten.memorytester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    private TextView question;
    private String s;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        question = (TextView)findViewById(R.id.txtQuestion);

        //Add new wrong items every time
        Items.questionItems.clear();
        Items.questionItems = (ArrayList<String>)Items.rememberItems.clone();
        for (int i = 0;i<10;i++){
            if (!Items.wordList.isEmpty()){
                int j = new Random().nextInt(Items.wordList.size());
                Items.questionItems.add(Items.wordList.get(j));
                Items.wordList.remove(j);
            }
        }
        question.setText(getNextQuestion());
    }
    public void onClickTrue(View view){
        checkAnswer(true);
    }

    public void onClickFalse(View view){
       checkAnswer(false);
    }

    private void checkAnswer(Boolean guess){
        if(Items.rememberItems.contains(question.getText()) == guess){
            s = "Correct";
            Stats.Correct++;
        }
        else{
            s = "Wrong";
            Stats.Wrong++;
        }
        Stats.Total++;
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
        question.setText(getNextQuestion());
    }

    private String getNextQuestion(){
        return (""+Items.questionItems.get(new Random().nextInt(Items.questionItems.size())));

    }

    //Create question content for a new game

}
