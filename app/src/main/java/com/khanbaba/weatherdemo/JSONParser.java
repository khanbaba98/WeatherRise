package com.khanbaba.weatherdemo;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class JSONParser {

    public JSONParser() {
    }

    public String loadJsonFromAsset(Context context){
        String json = null;
        try {
            InputStream in = context.getAssets().open("weather_data.json");

            int size = in.available();

            byte[] buffer = new byte[size];

            in.read(buffer);

            in.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException exception) {
            exception.printStackTrace();
            Toast.makeText(context, "exp", Toast.LENGTH_SHORT).show();
        }
        return json;
    }

}
