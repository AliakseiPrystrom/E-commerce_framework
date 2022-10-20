package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;

public class JsonDataUtil {
    private final static String testDataFilePath = "src/test/resources/testdata.json";
    private final static String testUrlsPath = "src/test/resources/testurls.json";
    private final static String testConfigPath = "src/test/resources/configuration.json";

    private static String getJsonString(String jsonFilePath,String key){
        String value = "";
        try {
            FileReader reader = new FileReader(jsonFilePath);
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            value = jsonObject.get(key).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }return value;
    }

    public static String get(String type, String key) {
        String value = "";
        switch (type) {
            case ("config"):
                value = getJsonString(testConfigPath,key);
                break;
            case ("testurls"):
                value = getJsonString(testUrlsPath,key);
                break;
            case ("testdata"):
                value = getJsonString(testDataFilePath,key);
                break;
            default:
                break;
        }
        return StringUtil.deleteQuotes(value);
    }
}
