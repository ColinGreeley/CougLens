package com.E404.couglens.JSON;

import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParserJSON {

    private String fileLocation;
    private String name;

    public ParserJSON(String fileLocation) {
        this.fileLocation = fileLocation;
        name = parseForObjectName();
    }

    private String parseForObjectName() {
        JsonParser parser = new JsonParser();

        try {
            FileReader reader = new FileReader(fileLocation);
            Object obj = parser.parse(reader);

            JSONArray list = (JSONArray) obj;

            List<String> possibilities = new ArrayList<String>();

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

        return fileLocation;
    }

    public String getName() {
        return name;
    }

}
