package com.example.todolisttabbed;

import android.sax.Element;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class TaskListAdapter extends RecyclerView.Adapter {
    private ArrayList<ArrayList<String>> mDataset;

    public TaskListAdapter(){
        this.mDataset = new ArrayList<>();
    }

    public static class ElementsHolder extends RecyclerView.ViewHolder
    {
        public TextView txt;
        public ElementsHolder(TextView v)
        {
            super(v);
            txt = v;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        TextView v = (TextView) new TextView(parent.getContext());
        return new ElementsHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        String text = "[ " + mDataset.get(position).get(0) + " ] - " + mDataset.get(position).get(1);
        ((ElementsHolder)holder).txt.setText(text);
    }

    @Override
    public int getItemCount() {
        return this.mDataset.size();
    }

    public void addItem(String taskName, String taskDate) {
        //String taskString = "[ " + taskName + " ] - " + taskDate;
        ArrayList<String> itemArray = new ArrayList<>() ;
        itemArray.add(taskName);
        itemArray.add(taskDate);
        mDataset.add(itemArray);
        this.notifyDataSetChanged();
    }

    public ArrayList<ArrayList<String>> getmDataset(){
        return this.mDataset;
    }

}
