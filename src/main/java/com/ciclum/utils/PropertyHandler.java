package com.ciclum.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class PropertyHandler {
    private JSONParser parser;

    private String chromeDriverPath;
    private String configFileName ="src/main/resources/chrome_driver_options.json";

    public PropertyHandler() {
    }

    public String getChromeDriverPath() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(configFileName));
            chromeDriverPath = (String) jsonObject.get("chromeDriverPath");
            String browser = (String) jsonObject.get("browser");
        } catch (FileNotFoundException| ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chromeDriverPath;
    }

    public List<String> getChromeOptionsArgs() {
        List<String> chromeOptionsArgs = new ArrayList<String>();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(configFileName));
            chromeOptionsArgs = (List<String>) jsonObject.get("chromeOptionsArgs");
        } catch (FileNotFoundException| ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chromeOptionsArgs;
    }
}
