package com.E404.couglens.JSON;

import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses JSON files
 */

public class ParserJSON {

    private String fileLocation;
    private List<String> possibilities;

    /**
     * @param fileLocation
     * Passes in file location to the file we want to parse
     */
    public ParserJSON(String fileLocation) {
        this.fileLocation = fileLocation;
        this.possibilities = parseForObjectName();
    }

    /**
     * Parses through the file for the data
     * @return
     */
    private List<String> parseForObjectName() {
        JsonParser parser = new JsonParser();

        List<String> possibilities = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(fileLocation);
            Object obj = parser.parse(reader);

            JSONArray list = (JSONArray) obj;

            for(int i = 0; i < list.length(); i++) {
                try {
                    JSONObject jsonObject = list.getJSONObject(i);

                    String possibility = (String) jsonObject.opt("name");
                    possibilities.add(possibility);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return possibilities;
    }
}
