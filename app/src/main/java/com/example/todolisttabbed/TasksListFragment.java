package com.example.todolisttabbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TasksListFragment  extends Fragment {

    private TaskListAdapter mTaskListAdapter  = new TaskListAdapter();
    private RecyclerView recycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_tab_tasks_list,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler = (RecyclerView) view.findViewById(R.id.recyclerViewTasksList);
        recycler.setHasFixedSize(true);
        LinearLayoutManager layManage = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layManage);
        recycler.setAdapter(mTaskListAdapter);
    }

    public TaskListAdapter getmTaskListAdapter(){
        return mTaskListAdapter;
    }

    public void setmTaskListAdapter(TaskListAdapter taskListAdapter){
        mTaskListAdapter = taskListAdapter;
    }
}
