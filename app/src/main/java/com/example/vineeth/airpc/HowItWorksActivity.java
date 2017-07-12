package com.example.vineeth.airpc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class HowItWorksActivity extends AppCompatActivity {
    ArrayList<String> groupTitles = new ArrayList<String>();
    HashMap<String,Integer> childLayouts = new HashMap<String,Integer>();
    private ArrayList<Integer> groupIcons = new ArrayList<Integer>();
    ExpandableListView elvHowItWorks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_it_works);

        elvHowItWorks = (ExpandableListView) findViewById(R.id.elvHowItWorks);
        setUpELV();

        ExpandableListAdapter expandableListAdapter = new AboutEVAdapter(this,groupTitles,groupIcons,childLayouts);
        elvHowItWorks.setAdapter(expandableListAdapter);



        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("How It Works");
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    // Populating the Expandable List View With Data
     public void setUpELV(){
         groupTitles.add("What are we measuring?");
         groupIcons.add(R.drawable.what_are_we_measuring);
         groupTitles.add("How are we measuring air quality?");
         groupIcons.add(R.drawable.how_are_we_measuring);
         groupTitles.add("How We Measure");
         groupIcons.add(R.drawable.what_are_we_measuring);
         groupTitles.add("How We Measure");
         groupIcons.add(R.drawable.how_are_we_measuring);
         groupTitles.add("How We Measure");
         groupIcons.add(R.drawable.what_are_we_measuring);
         groupTitles.add("How We Measure");
         groupIcons.add(R.drawable.how_are_we_measuring);

         childLayouts.put(groupTitles.get(0),R.layout.layout_what_are_we_measuring);
         childLayouts.put(groupTitles.get(1),R.layout.layout_measuring_air_quality);
         childLayouts.put(groupTitles.get(2),R.layout.about_child_view);
         childLayouts.put(groupTitles.get(3),R.layout.about_child_view);
         childLayouts.put(groupTitles.get(4),R.layout.about_child_view);
         childLayouts.put(groupTitles.get(5),R.layout.about_child_view);
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                onBackPressed();
                break;

        }
        return true;
    }
}
