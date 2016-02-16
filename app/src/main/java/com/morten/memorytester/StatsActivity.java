package com.morten.memorytester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StatsActivity extends AppCompatActivity {

    private TextView tTotal;
    private TextView tCorrect;
    private TextView tWrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        tTotal = (TextView)findViewById(R.id.txtTotalGuess);
        tCorrect = (TextView) findViewById(R.id.txtCorrectGuess);
        tWrong = (TextView) findViewById(R.id.txtWrongGuess);

        tTotal.setText(""+Stats.Total);
        tCorrect.setText(""+Stats.Correct);
        tWrong.setText(""+Stats.Wrong);
    }
}
