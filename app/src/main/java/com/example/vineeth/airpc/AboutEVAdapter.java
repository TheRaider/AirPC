package com.example.vineeth.airpc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vinee_000 on 28-05-2017.
 */

// Expandable View Adapter for populating ABOUT Layout
public class AboutEVAdapter extends BaseExpandableListAdapter{
   private ArrayList<String> groupTitles = new ArrayList<String>();
    private ArrayList<Integer> groupIcons = new ArrayList<Integer>();
   private HashMap<String,Integer> childLayouts = new HashMap<String,Integer>();

    Context mContext;

    public AboutEVAdapter(Context mContext,ArrayList<String> groupTitles, ArrayList<Integer> groupIcons,
                          HashMap<String, Integer> childLayouts ) {
        this.groupTitles = groupTitles;
        this.childLayouts = childLayouts;
        this.mContext = mContext;
        this.groupIcons = groupIcons;
    }

    @Override
    public int getGroupCount() {
       return groupTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childLayouts.get(groupTitles.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View customView = LayoutInflater.from(mContext).inflate(R.layout.about_group_view,null,false);
        TextView tvTitleGroup = (TextView) customView.findViewById(R.id.tvTitleGroup);
        tvTitleGroup.setText(groupTitles.get(groupPosition));
        ImageView ivIconGoup = (ImageView) customView.findViewById(R.id.ivIconGoup);
        ivIconGoup.setImageResource(groupIcons.get(groupPosition));


        return customView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View customView = LayoutInflater.from(mContext).inflate(childLayouts.get(groupTitles.get(groupPosition)),null,false);


        return customView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
