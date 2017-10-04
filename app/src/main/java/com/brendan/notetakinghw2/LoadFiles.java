package com.brendan.notetakinghw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.io.InputStreamReader;



/**
 * Created by dsaffo on 10/4/2017.
 */



public class LoadFiles {

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile (String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }


}
