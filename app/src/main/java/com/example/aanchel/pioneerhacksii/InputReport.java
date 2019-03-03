package com.example.aanchel.pioneerhacksii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class InputReport extends AppCompatActivity {
    private EditText incidentDescr;
    private EditText incidentLocation;
    private EditText incidentDist;
    private EditText incidentType;
    private EditText incident;
    private Button send;
    private Button btnIncident;

    public static ArrayList<Incident> types = new ArrayList<Incident>();
    public static ArrayList<Incident> robbery = new ArrayList<Incident>();
    public static ArrayList<Incident> assault_battery = new ArrayList<Incident>();
    public static ArrayList<Incident> kidnapping = new ArrayList<Incident>();
    public static ArrayList<Incident> homicide = new ArrayList<Incident>();


    public static void printList() {
        Incident a = new Incident(5, "Prius broken into", "robbery", "Cupertino, California");
        types.add(a);
        Incident b = new Incident(10, "Apartment broken into", "robbery", "Sunnyvale, California");
        types.add(b);
        Incident c = new Incident(15,"TV stolen", "robbery", "Fremont California");
        types.add(c);
        Incident d = new Incident(20, "Locked bike stolen", "robbery", "San Jose, California");
        types.add(d);
        Incident e = new Incident(35, "Apple Watch stolen", "robbery", "San Francisco, California");
        types.add(e);
        Incident f = new Incident(5, "Man punched in bar", "assault_battery", "Cupertino, California");
        types.add(f);
        Incident g = new Incident(10, "Man attacked with baseball bat", "assault_battery", "Sunnyvale, California");
        types.add(g);
        Incident h = new Incident(15,"Woman hit sister during family reunion", "assault_battery", "Fremont California");
        types.add(h);
        Incident i2 = new Incident(20, "Local man hit with shovel during bar fight", "assault_battery", "San Jose, California");
        types.add(i2);
        Incident j = new Incident(35, "Local Student attacks classmate with textbook", "assault_battery", "San Francisco, California");
        types.add(j);
        Incident k = new Incident(5, "Child abducted", "kidnapping", "Cupertino, California");
        types.add(k);
        Incident l = new Incident(10, "Child stolen from rightful parent in divorce case", "kidnapping", "Sunnyvale, California");
        types.add(l);
        Incident m = new Incident(15,"5 year old child gone missing", "kidnapping", "Fremont California");
        types.add(m);
        Incident n = new Incident(20, "10 year old boy missing for 2 days", "kidnapping", "San Jose, California");
        types.add(n);
        Incident o = new Incident(35, "Small girl kidnapped at park", "kidnapping", "San Francisco, California");
        types.add(o);
        Incident p = new Incident(5, "Man shot and killed", "homicide", "Cupertino, California");
        types.add(p);
        Incident q = new Incident(10, "Woman murdered in her apartment", "homicide", "Sunnyvale, California");
        types.add(q);
        Incident r = new Incident(15, "Man stabbed and murdered", "homicide", "Fremont California");
        types.add(r);
        Incident s = new Incident(20, "Woman stabbed by ex-boyfriend", "homicide", "San Jose, California");
        types.add(s);
        Incident t = new Incident(35, "Child found dead", "homicide", "San Francisco, California");
        types.add(t);

        sortIntoTypes(types);
        sortHeap(robbery);
        System.out.println("Robberies near you: \n");
        for (int i = 0; i < robbery.size(); i++) {
            System.out.print("\t" + robbery.get(i).toString());
        }
        System.out.println("Assaults/Battery Incidents near you: \n");
        for (int i = 0; i < assault_battery.size(); i++) {
            System.out.print("\t" + assault_battery.get(i).toString());
        }
        System.out.println("Kidnapping Incidents near you: \n");
        for (int i = 0; i < kidnapping.size(); i++) {
            System.out.print("\t" + kidnapping.get(i).toString());
        }
        System.out.println("Homicide Incidents near you: \n");
        for (int i = 0; i < homicide.size(); i++) {
            System.out.print("\t" + homicide.get(i).toString());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        incidentType = (EditText) findViewById(R.id.incidentType);
        incidentDescr = (EditText) findViewById(R.id.incidentDescr);
        incidentLocation = (EditText) findViewById(R.id.incidentLocation);
        incidentDist = (EditText) findViewById(R.id.incidentDist);

        send = (Button) findViewById(R.id.button);
        btnIncident = (Button) findViewById(R.id.btnIncidents);

        sendFunctionality();
        btnIncidentFunctionality();
    }

    private void btnIncidentFunctionality() {
        btnIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(InputReport.this, IncidentsPage.class));
            }
        });
    }

    private void sendFunctionality() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = incidentType.getText().toString().trim();
                String descr = incidentDescr.getText().toString().trim();
                String location = incidentLocation.getText().toString().trim();
                long dist = Long.parseLong(incidentDist.getText().toString().trim());

                Incident newIncident = new Incident(dist, descr, type, location);
                types.add(newIncident);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view){
        //placeholder
    }

    public static void sortIntoTypes(ArrayList<Incident> types) {
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).getType().equals("robbery")) {
                robbery.add(types.get(i));
            }
            if (types.get(i).getType().equals("assault_battery")) {
                assault_battery.add(types.get(i));
            }
            if (types.get(i).getType().equals("kidnapping")) {
                kidnapping.add(types.get(i));
            }
            if (types.get(i).getType().equals("homicide")) {
                homicide.add(types.get(i));
            }
        }
    }


    public static void sortHeap(ArrayList<Incident> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            buildMaxHeap(arr, 0, i);
            swap(arr, 0, i);
        }
    }

    private static void buildMaxHeap(ArrayList<Incident> arr, int startIndex, int endIndex) {
        boolean isMaxHeap = false;
        while (!isMaxHeap) {
            isMaxHeap = true;
            int startRow = (int)(Math.log(endIndex+1)/Math.log(2));
            for (int i = startRow; i > 0; i--) {
                int rowStartIndex = (int)((Math.pow(2,  i - 1)) - 1);
                int rowEndIndex = (int)((Math.pow(2, i))-2);
                for (int j = rowStartIndex; j <= rowEndIndex; j++) {
                    int biggest = j;
                    int leftChildNodeIndex = 2*j + 1;
                    int rightChildNodeIndex = 2*j + 2;
                    if ((leftChildNodeIndex <= endIndex) && (arr.get(biggest).compareTo(arr.get(leftChildNodeIndex)) < 0)) {
                        biggest = leftChildNodeIndex;
                    }
                    if ((rightChildNodeIndex <= endIndex) && (arr.get(biggest).compareTo(arr.get(rightChildNodeIndex)) < 0 ) ) {
                        biggest = rightChildNodeIndex;
                    }
                    if (biggest != j) {
                        swap(arr, j, biggest);
                        isMaxHeap = false;
                    }
                }
            }
        }
    }
    public static void swap(ArrayList <Incident> arr, int a, int b){
        Incident temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

}
