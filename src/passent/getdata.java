/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passent;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author nasrallah
 */
public class getdata {

    public String data[][];

    public getdata() {
        readJson("data.json");
    }

    public void readJson(String file) {
        JSONParser parser = new JSONParser();

        try {
            FileReader fileReader = new FileReader(file);
            JSONArray json = (JSONArray) parser.parse(fileReader);

            Iterator i = json.iterator();
            int q = 0;
            data = new String[json.size()][5];
            while (i.hasNext()) {
                JSONObject s = (JSONObject) i.next();
                data[q][0] = (String) s.get("r1");
                data[q][1] = (String) s.get("r2");
                data[q][2] = (String) s.get("r3");
                data[q][3] = (String) s.get("x");
                data[q++][4] = (String) s.get("output");
                System.out.println(s.get("r1") + "  +  " + s.get("r2") + " + " + s.get("r3") + " + " + s.get("x") + " = " + s.get("output"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
