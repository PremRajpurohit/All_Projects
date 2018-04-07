package com.example.samuelraj.searchdialogexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Search(View view)
    {
        boolean b = onSearchRequested();
        Log.d("App:",String.valueOf(b));
    }
}
