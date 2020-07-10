package com.devendrakumar.trackcovid19;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;
    private Context context;
    TextView tvCountry, tvccases, tvcRecoverd, tvcdeaths, tvctodaycases, tvctodaydeaths, tvtotalcases;
    ImageView tvcimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent=getIntent();
        positionCountry = intent.getIntExtra("position",0);

        tvCountry = findViewById(R.id.tvCountry);

        tvtotalcases = findViewById(R.id.tvtotalcases);
        tvccases = findViewById(R.id.tvcActive);
        tvcRecoverd = findViewById(R.id.tvcRecovered);
        tvcdeaths = findViewById(R.id.tvcdeaths);
        tvctodaycases = findViewById(R.id.tvctodaycases);
        tvctodaydeaths = findViewById(R.id.tvctodaydeaths);

        tvCountry.setText(MainActivity.countryModelList.get(positionCountry).getCountry());

        tvtotalcases.setText(MainActivity.countryModelList.get(positionCountry).getTotalcases());
        tvccases.setText(MainActivity.countryModelList.get(positionCountry).getCases());
        tvcRecoverd.setText(MainActivity.countryModelList.get(positionCountry).getRecovered());
        tvcdeaths.setText(MainActivity.countryModelList.get(positionCountry).getDeaths());
        tvctodaycases.setText(MainActivity.countryModelList.get(positionCountry).getTodaycases());
        tvctodaydeaths.setText(MainActivity.countryModelList.get(positionCountry).getTodaydeaths());

    }
}
