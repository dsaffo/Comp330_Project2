package com.brendan.notetakinghw2;

import android.content.Context;
import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    public static ArrayList<String> checkIdentifiersTest (ArrayList<Note> notes, String text){
        ArrayList<String> currentIDs = new ArrayList<String>();
        ArrayList<String> IDs = Utilities.sortMarks("!", text);
        ArrayList<String> newIDs = new ArrayList<String>();
        for (int i = 0; i < notes.size(); i++){
            currentIDs.addAll(notes.get(i).getnIDs());
        }



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

        return newIDs;
    }

    public static ArrayList<Note> saveNewNote(Note note, ArrayList<Note> currentNotes){
        ArrayList<Note> notes = new ArrayList<>();
        notes.addAll(currentNotes);
        notes.add(note);
        return notes;
    }


    ArrayList<Note> list = new ArrayList<>();


    //Time, Title, Content
    String title1 = "test";
    String content1 = "This is a test #test";
    Long time = 1L;

    String title2 = "test2";



    Note test1 = new Note(time,title1,content1,Utilities.sortMarks("@", content1), Utilities.sortMarks("#", content1), checkIdentifiersTest(list,content1), Utilities.sortMarks("^", content1) );
    ArrayList<Note> list2 = saveNewNote(test1, list);


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(1, test1.getnTopics().size());
    }
}