package com.brendan.notetakinghw2;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Brendan on 10/2/17.
 */

//Serializable allows for the object states to be saved for future use
public class Note implements Serializable{
    private long nDateTime;
    private String nTitle;
    private String nContent;

    public Note(long DateTime, String Title, String Content) {
        nDateTime = DateTime;
        nTitle = Title;
        nContent = Content;
    }

    public long getnDateTime() {
        return nDateTime;
    }

    public String getnTitle() {
        return nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnDateTime(long nDateTime) {
        this.nDateTime = nDateTime;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public String getDateTimeAsString(Context context){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", context.getResources().getConfiguration().locale);
        sdf.setTimeZone(TimeZone.getDefault());

        return sdf.format(new Date(nDateTime));
    }
}