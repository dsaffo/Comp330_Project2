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


    public static ArrayList<String> checkIdentifiersTest(ArrayList<Note> notes, String text) {
        ArrayList<String> currentIDs = new ArrayList<String>();
        ArrayList<String> IDs = Utilities.sortMarks("!", text);
        ArrayList<String> newIDs = new ArrayList<String>();
        for (int i = 0; i < notes.size(); i++) {
            currentIDs.addAll(notes.get(i).getnIDs());
        }


        for (int i = 0; i < IDs.size(); i++) {
            if (currentIDs.contains(IDs.get(i))) {

            } else {

                currentIDs.add(IDs.get(i));
                newIDs.add(IDs.get(i));

            }
        }

        return newIDs;
    }

    public static ArrayList<Note> saveNewNote(Note note, ArrayList<Note> currentNotes) {
        ArrayList<Note> notes = new ArrayList<>();
        notes.addAll(currentNotes);
        notes.add(note);
        return notes;
    }


    ArrayList<Note> list = new ArrayList<>();


    //Time, Title, Content
    String title1 = "test";
    String content1 = "This is a test for topics #test";
    Long time = 1L;

    String title2 = "Wednesday meeting";
    String content2 = "This is a test for mentions @mention";

    String title3 = "Thursday meeting";
    String content3 = "This is a test for references ^reference";

    String title4 = "Friday meeting";
    String content4 = "This is a test for multiple and equal identifiers !hello !hello";

    String title5 = "Saturday meeting";
    String content5 = "This is a test for multiple and different identifiers !hello !water";




    Note test1 = new Note(time, title1, content1, Utilities.sortMarks("@", content1), Utilities.sortMarks("#", content1), checkIdentifiersTest(list, content1), Utilities.sortMarks("^", content1));
    ArrayList<Note> list2 = saveNewNote(test1, list);

    Note test2 = new Note(time, title2, content2, Utilities.sortMarks("@", content2), Utilities.sortMarks("#", content2), checkIdentifiersTest(list2, content2), Utilities.sortMarks("^", content2));
    ArrayList<Note> list3 = saveNewNote(test2, list2);

    Note test3 = new Note(time, title3, content3, Utilities.sortMarks("@", content3), Utilities.sortMarks("#", content3), checkIdentifiersTest(list3, content3), Utilities.sortMarks("^", content3));
    ArrayList<Note> list4 = saveNewNote(test3, list3);

    Note test4 = new Note(time, title4, content4, Utilities.sortMarks("@", content4), Utilities.sortMarks("#", content4), checkIdentifiersTest(list4, content4), Utilities.sortMarks("^", content4));
    ArrayList<Note> list5 = saveNewNote(test4, list4);

    Note test5 = new Note(time, title5, content5, Utilities.sortMarks("@", content5), Utilities.sortMarks("#", content5), checkIdentifiersTest(list5, content5), Utilities.sortMarks("^", content5));
    ArrayList<Note> list6 = saveNewNote(test5, list5);


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(1, test1.getnTopics().size());


    }

    @Test
    public void testMentions() throws Exception {

        assertEquals(1, test2.getnMentions().size());
    }


    @Test
    public void testingReferences() throws Exception {
        assertEquals(1, test3.getnRefs().size());

    }

    @Test
    public void testingMultipleIdentifiers() throws Exception {
        assertEquals(2, test5.getnIDs().size());
    }


    }





