package com.example.samuelraj.roompersistentexample;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5;
    Task task;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"AssistDB").build();
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);
    }

    public void Save(View view)
    {
        new Tasker().execute();
    }

    private class Tasker extends AsyncTask<Task,String,Boolean> {
        TaskDAO taskDAO;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            task = new Task();
            task.setName(et1.getText().toString());
            task.setCategory(et2.getText().toString());
            task.setState(et3.getText().toString());
            task.setDue_date(et4.getText().toString());
            task.setReminder(et5.getText().toString());
            taskDAO = db.taskDAO();
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            Toast.makeText(MainActivity.this,"saved",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Boolean doInBackground(Task... tasks) {
            taskDAO.insertAllTasks(task);
            return true;
        }
    }

}
