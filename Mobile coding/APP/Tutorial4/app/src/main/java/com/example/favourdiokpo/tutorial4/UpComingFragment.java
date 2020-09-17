package com.example.favourdiokpo.tutorial4;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpComingFragment extends ListFragment {

    View view;

    ListView list;

    String[] maintitle = {"hello", "no", "bye", "hi", "why"};
    String[] subtitle = {"Stop", "whoop", "yup", "loop", "stoop"};
    Integer[] colors = {1,2,3,4,5};


    Activity context;
    ListView newEntry;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final DataContainer dc2 = ViewModelProviders.of(this).get(DataContainer.class);
        view = inflater.inflate(R.layout.notifications_fragment, null);

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<40;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("title", "Meeting Title : " + maintitle[i]);
            hm.put("subtitle","Time and Date : " + subtitle[i]);

            if(colors[i] == 1) {
                newEntry.setBackgroundColor(Color.parseColor("#E064B0"));
                hm.put("entry", Integer.toString(colors[i]) );
            }
            else if(colors[i] == 2) {
                newEntry.setBackgroundColor(Color.parseColor("#2D9EDB"));
                hm.put("entry", Integer.toString(colors[i]) );
            }
            else if(colors[i] == 3) {
                newEntry.setBackgroundColor(Color.parseColor("#F0BD44"));
                hm.put("entry", Integer.toString(colors[i]) );
            }
            else if(colors[i] == 4) {
                newEntry.setBackgroundColor(Color.parseColor("#4D5FB9"));
                hm.put("entry", Integer.toString(colors[i]) );
            }
            else if(colors[i] == 5) {
                newEntry.setBackgroundColor(Color.parseColor("#6FDDC3"));
                hm.put("entry", Integer.toString(colors[i]) );
            }

            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "title","subtitle","entry" };

        // Ids of views in listview_layout
        int[] to = { R.id.title,R.id.subtitle,R.id.entry};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

}

