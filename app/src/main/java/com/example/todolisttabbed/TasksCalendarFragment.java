package com.example.todolisttabbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class TasksCalendarFragment extends Fragment{

    private CalendarView simpleCalendarView;
    private TaskListAdapter mTaskListAdapter  = new TaskListAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_tab_calendar,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView editTextTaskNameCalendar = (TextView) view.findViewById(R.id.taskNameCalendar);
        simpleCalendarView = (CalendarView) view.findViewById(R.id.calendarView);
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String stringDay = String.valueOf(dayOfMonth);
                String stringMonth = String.valueOf(month);

                if (dayOfMonth < 10){
                    stringDay = "0"+stringDay;
                }
                if (month < 10){
                    stringMonth = "0"+stringMonth;
                    //dateText = dayOfMonth + "/0" + month + "/" + year;
                }
                String dateText = stringDay + "/" + stringMonth + "/" + year;
                editTextTaskNameCalendar.setText(getTaskNameByDate(dateText));
            }
        });
    }

    public void setmTaskListAdapter(TaskListAdapter taskListAdapter){
        mTaskListAdapter = taskListAdapter;
    }

    public String getTaskNameByDate (String taskDate){
        String displayText = "";
        for (int i = 0; i < this.mTaskListAdapter.getItemCount(); i++){
            ArrayList<String> currentItemArray = this.mTaskListAdapter.getmDataset().get(i);
            if (currentItemArray.get(1).equals(taskDate)){
                displayText += currentItemArray.get(0) + "\n";
            }
        }
        if (displayText.equals("")){
            displayText = "Aucune tâche(s) prévue(s)";
        }
        return displayText;
    }
}
