package com.example.favourdiokpo.tutorial4;
import android.app.Activity;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {


    Activity context;
    String[] maintitle;
    String[] subtitle;
    Integer[] colors;
    ListView newEntry;


    public MyListAdapter(Activity context, String[] maintitle,String[] subtitle, Integer[] colors) {
        super(context, R.layout.upcoming_fragment, maintitle);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.colors = colors;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.upcoming_fragment, null,true);

        newEntry = view.findViewById(R.id.entry);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(maintitle[position]);
        subtitleText.setText(subtitle[position]);


        //SET THE COLOR FOR THE LINEAR LAYOUT
        for (int i = 0; i < 5; i++) {
            if(colors[i] == 1) {
                newEntry.setBackgroundColor(Color.parseColor("#E064B0"));
            }
            else if(colors[i] == 2) {
                newEntry.setBackgroundColor(Color.parseColor("#2D9EDB"));
            }
            else if(colors[i] == 3) {
                newEntry.setBackgroundColor(Color.parseColor("#F0BD44"));
            }
            else if(colors[i] == 4) {
                newEntry.setBackgroundColor(Color.parseColor("#4D5FB9"));
            }
            else if(colors[i] == 5) {
                newEntry.setBackgroundColor(Color.parseColor("#6FDDC3"));
            }
        }


        return rowView;

    };

}