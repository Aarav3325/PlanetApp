package com.aarav.planetapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);
        planetArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Earth", "1 Moon", R.drawable.earth);
        planetArrayList.add(planet1);

        Planet planet2 = new Planet("Mercury", "0 Moons", R.drawable.mercury);
        planetArrayList.add(planet2);

        Planet planet3 = new Planet("Venus", "0 Moons", R.drawable.venus);
        planetArrayList.add(planet3);

        Planet planet4 = new Planet("Mars", "2 Moons", R.drawable.mars);
        planetArrayList.add(planet4);

        Planet planet5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        planetArrayList.add(planet5);

        Planet planet6 = new Planet("Saturn", "83 Moons", R.drawable.saturn);
        planetArrayList.add(planet6);

        Planet planet7 = new Planet("Uranus", "27 Moons", R.drawable.uranus);
        planetArrayList.add(planet7);

        Planet planet8 = new Planet("Neptune", "14 Moons", R.drawable.neptune);
        planetArrayList.add(planet8);

        PlanetAdapter adapter = new PlanetAdapter(planetArrayList, getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Planet name is " + adapter.getItem(i).getPlanetName(), Toast.LENGTH_LONG).show();
            }
        });


    }
}