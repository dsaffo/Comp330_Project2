package com.brendan.notetakinghw2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    //Time, Title, Content
    String title1 = "test";
    String content1 = "This is a test #test";
    Long time = 1L;
    ArrayList<String> list = new ArrayList<String>();


    Note test1 = new Note(time,title1,content1,Utilities.sortMarks("@", content1), Utilities.sortMarks("#", content1), list);

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(1, test1.getnTopics().size());
    }
}