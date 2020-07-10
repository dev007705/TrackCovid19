package com.devendrakumar.trackcovid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import 	android.widget.TextView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MyCustomAdaptor extends ArrayAdapter<CountryModel> {

    private Context context;
    private List<CountryModel> countryModelList;

    public MyCustomAdaptor(@NonNull Context context, List<CountryModel> countryModelList) {
        super(context, R.layout.list_custom_item, countryModelList);
        this.context=context;
        this.countryModelList=countryModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView countryName = view.findViewById(R.id.countryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        ListView listView = view.findViewById(R.id.listView);

        countryName.setText(countryModelList.get(position).getCountry());
        Glide.with(context).load(countryModelList.get(position).getFlag()).into(imageView);

        return view;
    }
}
