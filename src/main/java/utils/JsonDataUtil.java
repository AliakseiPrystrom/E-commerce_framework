package utils;

import org.json.JSONObject;

import java.io.*;

public class JsonDataUtil {
    private final static String testDataFilePath = "src/test/resources/testdata.json";
    private final static String testUrlsPath = "src/test/resources/testurls.json";
    private final static String testConfigPath = "src/test/resources/configuration.json";

    public static String get(String type, String key) {
        JSONObject object;
        switch (type) {
            case ("config"):
                object = new JSONObject(getJsonString(testConfigPath));
                break;
            case ("testurls"):
                object = new JSONObject(getJsonString(testUrlsPath));
                break;
            case ("testdata"):
                object = new JSONObject(getJsonString(testDataFilePath));
                break;
            default:
                object = null;
                break;
        }
        return object.getString(key);
    }

    private static String getJsonString(String path) {
        String json = "";
        File file = new File(path);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            while (dis.available() != 0) {
                json += dis.readLine();
            }
            json = json.replace("null", "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                bis.close();
                dis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return json;
    }
}
