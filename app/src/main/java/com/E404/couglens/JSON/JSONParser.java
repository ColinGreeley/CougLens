package com.E404.couglens.JSON;

import org.json.JSONArray;

import java.io.FileReader;

public class JSONParser {

    private String fileLocation;
    private String name;

    public JSONParser(String fileLocation) {
        this.fileLocation = fileLocation;
        name = parseForObjectName();
    }

    private String parseForObjectName() {
        JSONParser parser = new JSONParser(fileLocation);

        return fileLocation;
    }

    public String getName() {
        return name;
    }

}
