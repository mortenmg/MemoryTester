package com.morten.memorytester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    private TextView question;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        question = (TextView)findViewById(R.id.txtQuestion);
        question.setText(getNextQuestion());
    }
    public void onClickTrue(View view){
        checkAnswer(true);
    }

    public void onClickFalse(View view){
       checkAnswer(false);
    }

    private void checkAnswer(Boolean guess){
        if(Items.items.contains(question.getText()) == guess){
            s = "Correct";
        }
        else{
            s = "Wrong";
        }
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
        question.setText(getNextQuestion());
    }

    private String getNextQuestion(){
        return (""+Items.items.get(new Random().nextInt(Items.items.size())));

    }

    //Create question content for a new game

}
