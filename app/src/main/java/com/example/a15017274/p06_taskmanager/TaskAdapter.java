package com.example.a15017274.p06_taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017274 on 25/5/2017.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvName, tvDes;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        task = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDes = (TextView)rowView.findViewById(R.id.tvDes);


        Task currentTask = task.get(position);
        tvName.setText((position+1) + " " +currentTask.getName());
        tvDes.setText(currentTask.getDescription());

        return rowView;
    }
}
