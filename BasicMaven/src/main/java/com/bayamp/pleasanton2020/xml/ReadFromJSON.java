package com.bayamp.pleasanton2020.xml;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;





    public class ReadFromJSON {

        public static void main(String[] args) {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader("src/main/resources/data/company.json"));

                // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
                JSONObject jsonObject = (JSONObject) obj;

                // A JSON array. JSONObject supports java.util.List interface.
                JSONArray companyList = (JSONArray) jsonObject.get("Company List");


                Iterator<JSONObject> iterator = companyList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

