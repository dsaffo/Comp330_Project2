package com.brendan.notetakinghw2;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Brendan on 10/2/17.
 */

//Serializable allows for the object states to be saved for future use
public class Note implements Serializable{
    private long nDateTime;
    private String nTitle;
    private String nContent;
    private ArrayList nMentions;
    private ArrayList nTopics;

    public Note(long DateTime, String Title, String Content, ArrayList<String> Mentions, ArrayList<String> Topics) {
        nDateTime = DateTime;
        nTitle = Title;
        nContent = Content;
        nMentions = Mentions;
        nTopics = Topics;
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

    public ArrayList<String> getnMentions() { return nMentions; }

    public ArrayList<String> getnTopics() { return nTopics; }

    public void setnDateTime(long nDateTime) {
        this.nDateTime = nDateTime;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public void setnMentions(ArrayList<String> nMentions) { this.nMentions = nMentions; }

    public void setnTopics(ArrayList<String> nTopics) { this.nTopics = nTopics; }

    public String getDateTimeAsString(Context context){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", context.getResources().getConfiguration().locale);
        sdf.setTimeZone(TimeZone.getDefault());

        return sdf.format(new Date(nDateTime));
    }
}
