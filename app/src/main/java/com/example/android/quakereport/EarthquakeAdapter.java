package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



/**
 * Created by Kashyap on 04-07-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<earthquake> {
    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList<earthquake> earthquakes) {
        super(context,0,earthquakes);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        earthquake newword=getItem(position);



        TextView magnitude=(TextView)listItemView.findViewById(R.id.mag_text_view);
        String formattedMag = formatMag(newword.getmMagnitude());
        magnitude.setText(formattedMag);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int  magnitudeColor = getMagnitudeColor(newword.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


       String originalLocation = newword.getmLocation();
         String primary_offset;
         String secondary_offset;
           final  String LOCATION_SPLITTER = "of";
        if (originalLocation.contains(LOCATION_SPLITTER))
        {String[] p =originalLocation.split(LOCATION_SPLITTER);
            secondary_offset=p[0] + LOCATION_SPLITTER;
            primary_offset=p[1];}
        else{
            secondary_offset=getContext().getString(R.string.near_the);
            primary_offset=originalLocation;
        }

        TextView secondary= (TextView) listItemView.findViewById(R.id.location_offset);
        secondary.setText(secondary_offset);

        TextView primary = (TextView) listItemView.findViewById(R.id.primary_offset);
        primary.setText(primary_offset);


        Date dateObject = new Date(newword.getmDate());


        TextView date=(TextView)listItemView.findViewById(R.id.date_text_view);
        String formatedDate = formatDate(dateObject);
        date.setText(formatedDate);

        TextView time = (TextView)listItemView.findViewById(R.id.time);
        String formatedTime= formatTime(dateObject);
        time.setText(formatedTime);
        return listItemView;


    }
    private String formatDate(Date dateObject){
        SimpleDateFormat date = new SimpleDateFormat("LLL dd, yyyy");
        return date.format(dateObject);

    }
    private String formatTime(Date dateObject){
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        return time.format(dateObject);
    }
    private String  formatMag(double magn)
    {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magn);
    }
    private int getMagnitudeColor(double magni)
    {int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magni);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
