package com.example.android.quakereport;

/**
 * Created by Kashyap on 04-07-2017.
 */

public class earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String mUrl;

    public earthquake (double mag,String loc,long date,String url)
    {mMagnitude=mag;
    mLocation=loc;
    mDate=date;
    mUrl=url;}

    public double getmMagnitude(){
        return mMagnitude;
    }
    public String getmLocation(){
        return mLocation;
    }

    public long getmDate(){
        return mDate;
    }

    public String getmUrl(){return mUrl;}


}
