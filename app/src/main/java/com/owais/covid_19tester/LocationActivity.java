package com.owais.covid_19tester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editText_othercountry;
    private EditText editText_otherprovince;
    private EditText editText_othercity;
    private Spinner spinner_province;
    private Spinner spinner_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        spinner_province = (Spinner) findViewById(R.id.province_spinner);

        // Spinner click listener
        spinner_province.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Punjab");
        categories.add("Sindh");
        categories.add("Balochistan");
        categories.add("KPK");
        categories.add("Jammu and Kashmir");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_province.setAdapter(dataAdapter);


        spinner_city = (Spinner) findViewById(R.id.city_spinner);

        // Spinner click listener
        spinner_city.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> cities = new ArrayList<String>();
        cities.add("Lahore");
        cities.add("Islamabad");
        cities.add("Karachi");
        cities.add("Quetta");
        cities.add("Multan");

        // Creating adapter for spinner
        ArrayAdapter<String> citydataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);

        // Drop down layout style - list view with radio button
        citydataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_city.setAdapter(citydataAdapter);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.pakistan_country:
                if (checked) {
                    editText_othercountry = findViewById(R.id.enter_other_country);
                    editText_othercountry.setVisibility(View.GONE);
                    editText_otherprovince = findViewById(R.id.enter_other_province);
                    editText_otherprovince.setVisibility(View.GONE);
                    editText_othercity = findViewById(R.id.enter_other_city);
                    editText_othercity.setVisibility(View.GONE);
                    spinner_province = findViewById(R.id.province_spinner);
                    spinner_province.setVisibility(View.VISIBLE);
                    spinner_city = findViewById(R.id.city_spinner);
                    spinner_city.setVisibility(View.VISIBLE);
                    break;
                }
            case R.id.other_country:
                if (checked) {
                    editText_othercountry = findViewById(R.id.enter_other_country);
                    editText_othercountry.setVisibility(View.VISIBLE);
                    editText_otherprovince = findViewById(R.id.enter_other_province);
                    editText_otherprovince.setVisibility(View.VISIBLE);
                    editText_othercity = findViewById(R.id.enter_other_city);
                    editText_othercity.setVisibility(View.VISIBLE);
                    spinner_province = findViewById(R.id.province_spinner);
                    spinner_province.setVisibility(View.GONE);
                    spinner_city = findViewById(R.id.city_spinner);
                    spinner_city.setVisibility(View.GONE);
                    break;
                }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
