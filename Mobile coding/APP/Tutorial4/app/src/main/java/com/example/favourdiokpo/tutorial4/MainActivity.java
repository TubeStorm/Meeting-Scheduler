package com.example.favourdiokpo.tutorial4;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    int currentFragment = 0;
    public int currentCount = 0;

    ListView list;

    CalendarView calendarViews;
    TextView myDate;
    TextView myYear;

    String[] maintitle = {"hello", "no", "bye", "hi", "why"};
    String[] subtitle = {"Stop", "whoop", "yup", "loop", "stoop"};
    Integer[] colors = {1,2,3,4,5};


    Activity context;
    ListView newEntry;

//FRAGMENTS---------------------------------------------------------------------------------------------------------------------------------------------------------
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//FRAGMENTS2---------------------------------------------------------------------------------------------------------------------------------------------------------

            Fragment fragment = null;

            switch(item.getItemId()){
                case R.id.calendar_tab:
                    fragment = new CalendarFragment();
                    currentFragment = 0;
                    break;
                case R.id.schedule_tab:
                    fragment = new UpComingFragment();
                    currentFragment = 1;
                    break;
                case R.id.upcoming_tab:
                    fragment = new NotificationsFragment();
                    currentFragment = 2;
                    break;
                case R.id.navigation_settings:
                    fragment = new SettingsFragment();
                    currentFragment = 3;
                    break;

            }
            return loadFragment(fragment);
        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//CALENDAR---------------------------------------------------------------------------------------------------------------------------------------------------------

        calendarViews.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd");
                String da = sdf.format(new Date(year-1, month, day));


                String ye = "" + year;
                myYear.setText(ye);
                myDate.setText(da);
                System.out.print(da+"");
            }
        });


//LISTVIEW---------------------------------------------------------------------------------------------------------------------------------------------------------

            MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,colors);
            list=(ListView)findViewById(R.id.list);
            list.setAdapter(adapter);





            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    // TODO Auto-generated method stub
                    if(position == 0) {
                        //code specific to first mylist item
                        Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                    }

                    else if(position == 1) {
                        //code specific to 2nd mylist item
                        Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                    }

                    else if(position == 2) {

                        Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                    }
                    else if(position == 3) {

                        Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                    }
                    else if(position == 4) {

                        Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                    }

                }
            });



    }


    private boolean loadFragment(Fragment frag){
        if(frag != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,frag).commit();

            return true;
        }
        else return false;
    }



}
