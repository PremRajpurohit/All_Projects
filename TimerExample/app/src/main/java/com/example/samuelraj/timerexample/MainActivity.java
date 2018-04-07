package com.example.samuelraj.timerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar,progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar2 = (ProgressBar) findViewById(R.id.circular_progress_bar);
        progressBar.setMax(100);
        progressBar2.setMax(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int n = 0 ;
               while (n < 100)
                {
                    n++;
                    progressBar.setProgress(n);
                    progressBar2.setProgress(n);
                    try
                    {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
