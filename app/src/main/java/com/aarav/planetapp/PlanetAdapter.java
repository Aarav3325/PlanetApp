package com.aarav.planetapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetArrayList;
    Context context;

    public PlanetAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.item_list, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the planet object for the current position
        Planet planet = getItem(position);

        ViewHolder holder;
        final View result;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);

            holder = new ViewHolder();
            holder.planetName = convertView.findViewById(R.id.tvPlanet);
            holder.moonCount = convertView.findViewById(R.id.tvMoon);
            holder.planetImage = convertView.findViewById(R.id.ivPlanet);

            //result = convertView;

            convertView.setTag(holder); // Assoicate ViewHolder to the view it is displaying
        }
        else {
            //View is recycled
            holder = (ViewHolder) convertView.getTag();

            //result = convertView;
        }

        holder.planetImage.setImageResource(planet.getPlanetImage());
        holder.planetName.setText(planet.getPlanetName());
        holder.moonCount.setText(planet.getMoonCount());

        return convertView;
    }

    private static class ViewHolder{
        TextView planetName, moonCount;
        ImageView planetImage;
    }
}
