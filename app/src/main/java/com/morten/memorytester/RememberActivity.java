package com.morten.memorytester;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RememberActivity extends AppCompatActivity {

    TextView tCountdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember);
        tCountdown = (TextView)findViewById(R.id.txtCountdown);

        // 30 seconds coundowntimer
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                tCountdown.setText(""+(millisUntilFinished/1000));
            }

            public void onFinish() {
                finish(); // finish ActivityB
            }
        }.start();
    }

}
