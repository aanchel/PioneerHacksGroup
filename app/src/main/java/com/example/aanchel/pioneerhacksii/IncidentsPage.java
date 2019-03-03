package com.example.aanchel.pioneerhacksii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class IncidentsPage extends AppCompatActivity {
    private TextView textViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidents_page);

        textViewList = (TextView) findViewById(R.id.textViewList);

        InputReport.printList();
        ArrayList<Incident> types = InputReport.types;

        ArrayList<Incident> robbery = InputReport.robbery;
        ArrayList<Incident> assault_battery = InputReport.assault_battery;
        ArrayList<Incident> kidnapping = InputReport.kidnapping;
        ArrayList<Incident> homicide = InputReport.homicide;
        String temp = "";
        for (int i = 0; i < robbery.size(); i++) {
            temp += robbery.get(i).toString() + "\n";
        }
        String temp2 = "";
        for (int i = 0; i < assault_battery.size(); i++) {
            temp2 += assault_battery.get(i).toString() + "\n";
        }
        String temp3 = "";
        for (int i = 0; i < kidnapping.size(); i++) {
            temp3 += kidnapping.get(i).toString() + "\n";
        }
        String temp4 = "";
        for (int i = 0; i < homicide.size(); i++) {
            temp4 += homicide.get(i).toString() + "\n";
        }
        String print1 = "Robberies near you: \n\r";
        String print2 = "Assault/Battery incidents near you: \n\r";
        String print3 = "Kidnapping Incidents near you: \n\r";
        String print4 = "Homicide Incidents near you: \n\r";

        textViewList.setText(print1 + temp + print2 + temp2 + print3 + temp3+ print4+ temp4);
    }
}
