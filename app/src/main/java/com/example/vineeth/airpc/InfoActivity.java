package com.example.vineeth.airpc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private ArrayList<Pollutant> pollutantsList = new ArrayList<Pollutant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ListView llInfoAll = (ListView) findViewById(R.id.llInfoAll);
        populateList();
        BaseAdapter baseAdapter = new InfoAdapter(this,pollutantsList);
        llInfoAll.setAdapter(baseAdapter);






    }

    public void  populateList(){
        pollutantsList.add(new Pollutant("Carbon Monoxide" , "CO" , 360 ,"ppm"));
        pollutantsList.add(new Pollutant("Nitric Oxide" , "NO" , 360 ,"ppm"));
        pollutantsList.add(new Pollutant("Carbon Monoxide" , "CO" , 360 ,"ppm"));
        pollutantsList.add(new Pollutant("Carbon Monoxide" , "CO" , 360 ,"ppm"));
        pollutantsList.add(new Pollutant("Carbon Monoxide" , "CO" , 360 ,"ppm"));
        pollutantsList.add(new Pollutant("Carbon Monoxide" , "CO" , 360 ,"ppm"));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // To Enable Back Button Click
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
