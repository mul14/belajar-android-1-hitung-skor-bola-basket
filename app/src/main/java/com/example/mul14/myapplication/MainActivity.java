package com.example.mul14.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plus3PointToA = (Button) findViewById(R.id.plus3PointToA);
        Button plus2PointToA = (Button) findViewById(R.id.plus2PointToA);
        Button freeThrowToA = (Button) findViewById(R.id.freeThrowToA);
        Button plus3PointToB = (Button) findViewById(R.id.plus3PointToB);
        Button plus2PointToB = (Button) findViewById(R.id.plus2PointToB);
        Button freeThrowToB = (Button) findViewById(R.id.freeThrowToB);
        Button resetPoint = (Button) findViewById(R.id.resetPoint);

        plus3PointToA.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeScore('A', 3);
            }
        });

        plus2PointToA.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeScore('A', 2);
            }
        });

        freeThrowToA.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeScore('A', 1);
            }
        });

        plus3PointToB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeScore('B', 3);
            }
        });

        plus2PointToB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeScore('B', 2);
            }
        });

        freeThrowToB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeScore('B', 1);
            }
        });

        resetPoint.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeScore('A', 0);
                changeScore('B', 0);
            }
        });

    }

    protected void changeScore(char team, Integer score) {

        TextView t;
        CharSequence chara;
        Integer currentPoint;

        if (team == 'A') {
            t = (TextView) findViewById(R.id.pointToA);
        } else {
            t = (TextView) findViewById(R.id.pointToB);
        }

        chara = t.getText();
        currentPoint = Integer.valueOf(chara.toString()) + score;
        t.setText(Integer.toString(currentPoint));

        CharSequence notifyText = "Score to team " + team + " +" + score;

        Toast.makeText(MainActivity.this, notifyText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
