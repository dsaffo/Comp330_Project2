package com.brendan.notetakinghw2;

import android.content.Context;

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

    }
}
