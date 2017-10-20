package com.brendan.notetakinghw2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
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
    String content4 = "This is a test for multiple and equal identifiers !hello";

    String title5 = "Friday meeting";
    String content5 = "This is a test for multiple and equal identifiers #hello #water";

    String title6 = "Friday meeting";
    String content6 = "This is a test for no identifiers !BALLOON";

    String title7 = "Friday meeting";
    String content7 = "This is a test for no identifiers !!LUC";

    String title8 = "Saturday meeting";
    String content8 = "This is a test for id at the end @";

    String title9 = "Sunday meeting";
    String content9 = "This is a test for double mentions at the end @@";

    String title10 = "Monday meeting";
    String content10 = "This is a test for double topics ##";

    String title11 = "Tuesday meeting";
    String content11 = "This is a test for double references ^^";








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

    Note test6 = new Note(time, title6, content6, Utilities.sortMarks("@", content6), Utilities.sortMarks("#", content6), checkIdentifiersTest(list6, content6), Utilities.sortMarks("^", content6));
    ArrayList<Note> list7 = saveNewNote(test6, list6);

    Note test7 = new Note(time, title7, content7, Utilities.sortMarks("@", content7), Utilities.sortMarks("#", content7), checkIdentifiersTest(list7, content7), Utilities.sortMarks("^", content7));
    ArrayList<Note> list8 = saveNewNote(test7, list7);

    Note test8 = new Note(time, title8, content8, Utilities.sortMarks("@", content8), Utilities.sortMarks("#", content8), checkIdentifiersTest(list8, content8), Utilities.sortMarks("^", content8));
    ArrayList<Note> list9 = saveNewNote(test8, list8);

    Note test9 = new Note(time, title9, content9, Utilities.sortMarks("@", content9), Utilities.sortMarks("#", content9), checkIdentifiersTest(list9, content9), Utilities.sortMarks("^", content9));
    ArrayList<Note> list10 = saveNewNote(test9, list9);

    Note test10 = new Note(time, title10, content10, Utilities.sortMarks("@", content10), Utilities.sortMarks("#", content10), checkIdentifiersTest(list10, content10), Utilities.sortMarks("^", content10));
    ArrayList<Note> list11 = saveNewNote(test10, list10);

    Note test11 = new Note(time, title11, content11, Utilities.sortMarks("@", content11), Utilities.sortMarks("#", content11), checkIdentifiersTest(list11, content10), Utilities.sortMarks("^", content11));
    ArrayList<Note> list12 = saveNewNote(test11, list11);



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
    public void testingIdentifiers() throws Exception {
        assertEquals(1, test4.getnIDs().size());

    }


    @Test
    public void testGet() throws Exception {
        assertEquals(2, test5.getnIDs().size());

    }
    @Test
    public void assertTrueID() throws Exception{
        assertTrue(test5.getnIDs().size()== 1);
    }

    @Test
    public void testingNoIdentifier() throws Exception {
        assertEquals(0, test6.getnIDs().size());

    }

    @Test
    public void testingDoubles() throws Exception {
        assertEquals(0, test7.getnIDs().size());

    } //TODO:not reading the identifiers if they're next to each other. Only reading the first id

    @Test
    public void testIDentifieratEnd() throws Exception {
        assertEquals(1, test8.getnIDs().size());
    }
    @Test
    public void testDoubleTopics() throws Exception {
        assertEquals(1, test9.getnTopics().size());
        assertEquals(1, test9.getnIDs().size());
    }

    public void testDoubleReference() throws Exception {
        assertEquals(1, test10.getnRefs().size());
    }


}









