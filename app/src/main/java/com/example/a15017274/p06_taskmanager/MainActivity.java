package com.example.a15017274.p06_taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lv;
    TaskAdapter aa;
    ArrayList<Task> task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        lv = (ListView) findViewById(R.id.lvTask);


        DBHelper db = new DBHelper(MainActivity.this);
        task = new ArrayList<Task>();
        task.addAll(db.getAllTasks());
        aa = new TaskAdapter(this, android.R.layout.simple_list_item_1, task);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,
                        AddActivity.class);
                startActivityForResult(i, 123);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            DBHelper db = new DBHelper(MainActivity.this);
            task = new ArrayList<Task>();
            task.addAll(db.getAllTasks());
            aa = new TaskAdapter(this, android.R.layout.simple_list_item_1, task);
            lv.setAdapter(aa);
            aa.notifyDataSetChanged();
        }

    }
}
