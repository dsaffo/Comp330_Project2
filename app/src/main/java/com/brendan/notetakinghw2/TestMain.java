package com.brendan.notetakinghw2;

import android.content.Context;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dsaffo on 10/4/2017.
 */

public class TestMain {

    static LoadFiles lf = new LoadFiles();

    private Context context;



    public static void main(String[] args) {

        String test = null;
        try {
            test = lf.getStringFromFile("C:\\Users\\dsaffo\\Documents\\Comp330\\Comp330_Project2\\app\\src\\main\\assets\\test.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(test);

        String line = "@food was testy. @ sorry no@this @drink lots of. @night was fab. @three #four";

        ArrayList<String> mentions = new ArrayList<String>();

        Pattern pattern = Pattern.compile("(?<=^|\\s)\\@\\w+");

        Matcher matcher = pattern.matcher(line);
        while (matcher.find())
        {
            mentions.add(matcher.group());
        }
        System.out.println(mentions);



    }
}
