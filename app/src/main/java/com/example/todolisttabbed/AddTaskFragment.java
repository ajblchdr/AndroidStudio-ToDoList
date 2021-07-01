package com.example.todolisttabbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddTaskFragment extends Fragment {

    private TaskListAdapter mTaskListAdapter = new TaskListAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_tab_add_task,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Button btnAddTask = (Button) view.findViewById(R.id.buttonAddTask);
        final EditText editTextTaskName = (EditText) view.findViewById(R.id.editTextTask);
        final EditText editTexteDate = (EditText) view.findViewById(R.id.editTextDate);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textInputValue = editTextTaskName.getText().toString();
                String dateInputValue = editTexteDate.getText().toString();
                mTaskListAdapter.addItem(textInputValue, dateInputValue);
                String notification = "La tâche '"+textInputValue+"' a bien été ajouté au "+dateInputValue;
                Toast.makeText(getContext(), notification, Toast.LENGTH_LONG).show();
            }
        });

    }

    public TaskListAdapter getmTaskListAdapter(){
        return mTaskListAdapter;
    }

    public void setmTaskListAdapter(TaskListAdapter taskListAdapter){
        mTaskListAdapter = taskListAdapter;
    }





}
