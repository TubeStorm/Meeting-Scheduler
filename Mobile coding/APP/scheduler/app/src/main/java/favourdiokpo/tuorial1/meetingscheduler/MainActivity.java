package favourdiokpo.tuorial1.meetingscheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    CalendarView calendarViews;
    TextView myDate;
    TextView myYear;

    ListView list;
    String[] maintitle = {"hello", "no", "bye", "hi", "why"};
    String[] subtitle = {"Stop", "whoop", "yup", "loop", "stoop"};
    Integer[] colors = {1,2,3,4,5};


    Activity context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarViews = findViewById(R.id.calendarView);
        myDate = findViewById(R.id.myDate);
        myYear = findViewById(R.id.myYear);

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
        list = findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
}
