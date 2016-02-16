package com.morten.memorytester;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class RememberActivity extends AppCompatActivity {

    public ArrayList<String> QuestionContent;

    private static int ROW_COUNT = 1;
    private static int COL_COUNT = 1;
    private TableLayout contentTable;
    private Context context;

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

        createNewGame();
    }

    public ArrayList getQuestionContent(){
        return QuestionContent;
    }
    public void setQuestionContent(ArrayList<String> newQuestionContent){
        QuestionContent = newQuestionContent;
    }
    private void createNewGame() {
        QuestionContent = new ArrayList<String>();
        QuestionContent.add("Monkey");
        QuestionContent.add("Banana");
        QuestionContent.add("Denmark");
        QuestionContent.add("Computer");
        QuestionContent.add("Personal Data");
        QuestionContent.add("Memory");
        Items.items = new ArrayList<>();
        Items.items = QuestionContent;
        displayGame();
    }

    // add 2x3 TextViews to contentTable (view id = TableLayoutRemember)
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void displayGame(){
        contentTable = (TableLayout) findViewById(R.id.TableLayoutRemember);
        context = contentTable.getContext();

        TableLayout.LayoutParams tableRowParams=
                new TableLayout.LayoutParams
                        (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
        tableRowParams.setMargins(0,20,0,20);

        //Create rows
        TableRow tr1 = new TableRow(context);
        TableRow tr2 = new TableRow(context);
        tr1.setLayoutParams(tableRowParams);
        tr2.setLayoutParams(tableRowParams);

        //Create text views
        TextView t1 = new TextView(context);
        t1.setGravity(Gravity.CENTER);
        t1.setTextAppearance(this, android.R.style.TextAppearance_Medium);
        t1.setText(QuestionContent.get(0));

        TextView t2 = new TextView(context);
        t2.setGravity(Gravity.CENTER);
        t2.setTextAppearance(this, android.R.style.TextAppearance_Medium);
        t2.setText(QuestionContent.get(1));

        TextView t3 = new TextView(context);
        t3.setGravity(Gravity.CENTER);
        t3.setTextAppearance(this, android.R.style.TextAppearance_Medium);
        t3.setText(QuestionContent.get(2));

        TextView t4 = new TextView(context);
        t4.setGravity(Gravity.CENTER);
        t4.setTextAppearance(this, android.R.style.TextAppearance_Medium);
        t4.setText(QuestionContent.get(3));

        //Add TextViews to TableRows
        tr1.addView(t1);
        tr1.addView(t2);
        tr2.addView(t3);
        tr2.addView(t4);

        //Add row to contentTable
        contentTable.addView(tr1);
        contentTable.addView(tr2);

    }
}
