package com.example.vineeth.airpc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vinee_000 on 27-05-2017.
 */

public class InfoAdapter extends BaseAdapter {
    private ArrayList<Pollutant> pollutantsList = new ArrayList<Pollutant>();
    private Context mContext;

    public InfoAdapter( Context mContext , ArrayList<Pollutant> pollutantsList) {
        this.pollutantsList = pollutantsList;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return pollutantsList.size();
    }

    @Override
    public Object getItem(int position) {
        return pollutantsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = LayoutInflater.from(mContext).inflate(R.layout.pollutant_info,null,false);

        TextView pollutantFormula ,pollutantAmount , pollutantName , pollutantUnit;

        pollutantFormula = (TextView) customView.findViewById(R.id.pollutantFormula);
        pollutantAmount = (TextView) customView.findViewById(R.id.pollutantAmount);
        pollutantName = (TextView) customView.findViewById(R.id.pollutantName);
        pollutantUnit = (TextView) customView.findViewById(R.id.pollutantUnit);

        Pollutant pollutant = pollutantsList.get(position);

        pollutantFormula.setText(pollutant.getFormula());
        pollutantAmount.setText(pollutant.getAmount()+" ");
        pollutantName.setText(pollutant.getName());
        pollutantUnit.setText(pollutant.getUnit());

        return customView;
    }
}
