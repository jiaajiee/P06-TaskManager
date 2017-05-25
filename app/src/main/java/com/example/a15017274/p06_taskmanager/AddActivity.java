package com.example.a15017274.p06_taskmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    Button btnTaskAdd, btnCancel;
    EditText etName, etDes, etRemind;
    int reqCode = 12345;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnTaskAdd = (Button) findViewById(R.id.btnAddTask);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        etName = (EditText) findViewById(R.id.etName);
        etDes = (EditText) findViewById(R.id.etDescription);
        etRemind = (EditText) findViewById(R.id.etRemind);



        btnTaskAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbh = new DBHelper(AddActivity.this);
                dbh.insertTask(etName.getText().toString(), etDes.getText().toString());
                dbh.close();

                Intent i = new Intent();
                setResult(RESULT_OK, i);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, Integer.parseInt(etRemind.getText().toString()));

                Intent intent = new Intent(AddActivity.this,
                        TaskBroadcastReceiver.class);

                intent.putExtra("name", etName.getText().toString());

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        AddActivity.this, reqCode,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)
                        getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        pendingIntent);

                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();

            }
        });


    }
}
