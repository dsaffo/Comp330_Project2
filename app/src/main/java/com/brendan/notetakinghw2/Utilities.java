package com.brendan.notetakinghw2;

import android.content.Context;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

/**
 * Created by Brendan on 10/3/17.
 */


public class Utilities {



    public static final String FILE_EXTENSION = ".bin";

    //boolean to see if save was successful or not
    public static boolean saveNote(Context context, Note note){

        //filename will be the date with an extension of .bin
        String fileName = String.valueOf(note.getnDateTime()) + FILE_EXTENSION;

        FileOutputStream fos;
        ObjectOutputStream oos;


        try{//try to save to the private storage of the application
            fos = context.openFileOutput(fileName, context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            //write a new note
            oos.writeObject(note);
            oos.close();
            fos.close();

        } catch (IOException e){
            e.printStackTrace();
            return false; //tell the user something went wrong...should only happen if there's no space

        }

        return true;
    }

    public static ArrayList<Note> getAllSavedNotes(Context context){
        ArrayList<Note> notes = new ArrayList<>();

        File fileDir = context.getFilesDir();

        ArrayList<String> noteFiles = new ArrayList<>();

        for (String file : fileDir.list()){
            if(file.endsWith(FILE_EXTENSION)){
                noteFiles.add(file);
            }
        }

        FileInputStream fis;
        ObjectInputStream ois;

        for (int i=0; i <noteFiles.size(); i++) {
            try {
                fis = context.openFileInput(noteFiles.get(i));
                ois = new ObjectInputStream(fis);

                notes.add((Note) ois.readObject());

                fis.close();
                ois.close();

            } catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
                return null;
            }
        }

        return notes;
    }

    public static Note getNoteByName(Context context, String fileName){
        File file = new File(context.getFilesDir(), fileName);
        Note note;

        if(file.exists()){
            FileInputStream fis;
            ObjectInputStream ois;

            try{
                fis = context.openFileInput(fileName);
                ois = new ObjectInputStream(fis);

                note = (Note) ois.readObject();

                fis.close();
                ois.close();

            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                return null;
            }
            return note;
        }
        return null;
    }

    public static ArrayList<String> checkIdentifiers (ArrayList<Note> notes, String text, Boolean edit, Context context, String filename){
        ArrayList<String> currentIDs = new ArrayList<String>();;
        ArrayList<String> IDs = sortMarks("!", text);
        ArrayList<String> newIDs = new ArrayList<String>();
        for (int i = 0; i < notes.size(); i++){
            currentIDs.addAll(notes.get(i).getnIDs());
        }

        if (edit == true){
            Note currentNote = getNoteByName(context,filename);
            currentIDs.removeAll(currentNote.getnIDs());
        }

        Log.d("Current Ids: ", Arrays.toString(currentIDs.toArray()).replace("[", "").replace("]", ""));
        Log.d("Note Ids: ", Arrays.toString(IDs.toArray()).replace("[", "").replace("]", ""));
        for (int i = 0; i < IDs.size(); i++){
            if (currentIDs.contains(IDs.get(i))){
                Log.d("same", IDs.get(i).toString());
            }
            else {
                Log.d("new", IDs.get(i).toString());
                currentIDs.add(IDs.get(i));
                newIDs.add(IDs.get(i));

            }
        }
        Log.d("list of note IDs", Arrays.toString(newIDs.toArray()).replace("[", "").replace("]", ""));
        return newIDs;
    }

    public static ArrayList<String> sortMarks (String mark, String text){
        ArrayList<String> mentions = new ArrayList<String>();
        String regex = "(?<=^|\\s)\\" + mark +"\\w+";
        Pattern pattern = Pattern.compile(regex);

        if(mark == "!") {

        }

        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
        {
            mentions.add(matcher.group());
        }
        return mentions;
    }



    public static void deleteNote(Context context, String fileName) {
        File dir = context.getFilesDir();
        File file = new File(dir, fileName);

        if(file.exists()){
            file.delete();
        }
    }




    public static void testEvent(GoogleAccountCredential cred,String eventText) throws IOException {
        com.google.api.services.calendar.Calendar mService = null;

        HttpTransport transport = AndroidHttp.newCompatibleTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        mService = new com.google.api.services.calendar.Calendar.Builder(
                transport, jsonFactory, cred)
                .setApplicationName("Google Calendar API Android Quickstart")
                .build();

        //Log.d("Try", "Worked!");
        //String eventText = "Appointment ";
        mService.events().quickAdd("primary", "null").setText(eventText).execute();
    }

    public static String removeMarks(Note note){
        String text = note.getnContent();

        if (note.getnMentions() != null) {

            for (int i = 0; i < note.getnMentions().size(); i++){
                text = text.replaceAll(note.getnMentions().get(i),"");
            }
            Log.d("Remove Mentions", text);
        }
        if (note.getnTopics() != null) {
            for (int i = 0; i < note.getnTopics().size(); i++){
                text = text.replaceAll(note.getnTopics().get(i),"");
            }
            Log.d("Remove Topics", text);
        }
        if (note.getnIDs() != null) {
            for (int i = 0; i < note.getnIDs().size(); i++){
                text = text.replaceAll(note.getnIDs().get(i),"");
            }
            Log.d("Remove IDs", text);
        }
        if (note.getnRefs() != null) {
            for (int i = 0; i < note.getnRefs().size(); i++){
                text = text.replaceAll(note.getnRefs().get(i),"");
            }
            Log.d("Remove Refs", text);
        }
        return text;
    }

    public static boolean gCal(Note note){
        if (note.getnMentions().contains("@gcal")){
            return true;
        }
        else {
            return false;
        }
    }


}
