package com.devendrakumar.trackcovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.ListView;


import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvCases,tvActive,tvRecovered,tvDeaths;
    ListView listView;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;

    public static List<CountryModel> countryModelList = new ArrayList<>();
    CountryModel countryModel;
    MyCustomAdaptor myCustomAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvActive = findViewById(R.id.tvActive);

        listView=findViewById(R.id.listView);

        simpleArcLoader=findViewById(R.id.loader);
        scrollView=findViewById(R.id.scrollstats);

        fetchData();
        fetchCountry();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),DetailActivity.class).putExtra("position",position));
            }
        });

    }

    private void fetchCountry() {
        String url = "https://disease.sh/v3/covid-19/countries";
        simpleArcLoader.start();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject= jsonArray.getJSONObject(i);

                        String countryName = jsonObject.getString("country");
                        String totalcases= jsonObject.getString("cases");
                        String ccases = jsonObject.getString("active");
                        String cdeaths = jsonObject.getString("deaths");
                        String crecoverd = jsonObject.getString("recovered");
                        String todaycases = jsonObject.getString("todayCases");
                        String todayDeaths = jsonObject.getString("todayDeaths");

                        JSONObject object=jsonObject.getJSONObject("countryInfo");
                        String flagurl = object.getString("flag");

                        countryModel = new CountryModel(flagurl,countryName,totalcases,ccases,cdeaths,crecoverd,todaycases,todayDeaths);
                        countryModelList.add(countryModel);
                    }
                    myCustomAdaptor =new MyCustomAdaptor(MainActivity.this,countryModelList);
                    listView.setAdapter(myCustomAdaptor);
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void fetchData() {
        String url = "https://disease.sh/v3/covid-19/all";
        simpleArcLoader.start();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvCases.setText(jsonObject.getString("cases"));
                    tvRecovered.setText(jsonObject.getString("recovered"));
                    tvDeaths.setText(jsonObject.getString("deaths"));
                    tvActive.setText(jsonObject.getString("active"));

                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

}
