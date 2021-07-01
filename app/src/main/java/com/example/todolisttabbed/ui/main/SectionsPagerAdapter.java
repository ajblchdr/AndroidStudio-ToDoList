package com.example.todolisttabbed.ui.main;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolisttabbed.AddTaskFragment;
import com.example.todolisttabbed.R;
import com.example.todolisttabbed.TaskListAdapter;
import com.example.todolisttabbed.TasksCalendarFragment;
import com.example.todolisttabbed.TasksListFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;
    //private final TaskListAdapter myTaskListAdapter = new TaskListAdapter();
    private final AddTaskFragment addTaskFragment= new AddTaskFragment();
    private final TasksListFragment tasksListFragment = new TasksListFragment();
    private final TasksCalendarFragment tasksCalendarFragment = new TasksCalendarFragment();

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        tasksListFragment.setmTaskListAdapter(addTaskFragment.getmTaskListAdapter());
        tasksCalendarFragment.setmTaskListAdapter(addTaskFragment.getmTaskListAdapter());
        if (position == 0){
            return tasksListFragment;
        }
        else if (position == 1){
            return addTaskFragment;
        }
        else if (position == 2){
            return tasksCalendarFragment;
        }
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }

    //TextView taskNameCalendar = (TextView) ((Activity) mContext).findViewById(R.id.textView1);
}