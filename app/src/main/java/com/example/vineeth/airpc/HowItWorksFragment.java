package com.example.vineeth.airpc;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;


public class HowItWorksFragment extends Fragment {
    Context mContext;

    ArrayList<String> groupTitles = new ArrayList<String>();
    HashMap<String,Integer> childLayouts = new HashMap<String,Integer>();
    private ArrayList<Integer> groupIcons = new ArrayList<Integer>();
    ExpandableListView elvHowItWorks;

    public HowItWorksFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getContext();
        // Inflate the layout for this fragment
        View customView =  inflater.inflate(R.layout.fragment_how_it_works, container, false);
        elvHowItWorks = (ExpandableListView) customView.findViewById(R.id.elvHowItWorks);
        setUpELV();

        ExpandableListAdapter expandableListAdapter = new AboutEVAdapter(getContext(),groupTitles,groupIcons,childLayouts);
        elvHowItWorks.setAdapter(expandableListAdapter);

        return  customView;
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
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("How It Works");
    }

}
