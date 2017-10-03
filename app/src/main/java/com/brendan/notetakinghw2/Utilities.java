package com.brendan.notetakinghw2;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
}
