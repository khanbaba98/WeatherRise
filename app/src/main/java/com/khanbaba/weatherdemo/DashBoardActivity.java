package com.khanbaba.weatherdemo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    JSONParser jsonParser = new JSONParser();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> temperatureArrayList = new ArrayList<>();
                try{
                    String jason = jsonParser.loadJsonFromAsset(DashBoardActivity.this);
                    JSONObject weatherJson = new JSONObject(jason);
                    JSONArray weatherArray = weatherJson.getJSONArray("list");

                    for(int i=0; i<weatherArray.length();i++) {
                        try {
                            JSONObject day = weatherArray.getJSONObject(i);
                            JSONObject temp = day.getJSONObject("temp");
                            Double dayTemp = temp.getDouble("day");
                            String dayTempString = Double.toString(dayTemp);
                            System.out.println(dayTempString);

                            temperatureArrayList.add(dayTempString);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}


