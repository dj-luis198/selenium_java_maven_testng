package com.demoqa.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimple {

    public String[] GetJsonSimple(int i, String file) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(".\\src\\test\\resources\\fixtures\\" + file + ".json");
            Object obj = jsonParser.parse(reader);
            JSONArray list = (JSONArray) obj;// todo el json
            JSONObject values = (JSONObject) list.get(i);// muestra todo el objeto i
            JSONArray value = (JSONArray) values.get("check");// foco en todo el contenido de check (array)
            String[] valor = new String[value.size()];
            for (int j = 0; j < value.size(); j++) {
                valor[j] = value.get(j).toString();
            }
            return valor;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String GetJsonSimpleString(int i, String file) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(".\\src\\test\\resources\\fixtures\\" + file + ".json");
            Object obj = jsonParser.parse(reader);
            JSONArray list = (JSONArray) obj;// todo el json
            JSONObject values = (JSONObject) list.get(i);// muestra todo el objeto i
            String value = values.get("resp").toString();// get valor de resp y pasarlo a string
            return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
