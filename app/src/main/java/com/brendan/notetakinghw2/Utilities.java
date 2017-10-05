package com.brendan.notetakinghw2;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static ArrayList<String> sortMarks (String mark, String text){
        ArrayList<String> mentions = new ArrayList<String>();
        String regex = "(?<=^|\\s)\\" + mark +"\\w+";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
        {
            mentions.add(matcher.group());
        }
        return mentions;
    }
}
