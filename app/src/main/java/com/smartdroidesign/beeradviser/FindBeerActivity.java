package com.smartdroidesign.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

    }

    public void onClickFindBeer(View view) {
        // Registering views
        TextView brands = findViewById(R.id.brands);
        Spinner color = findViewById(R.id.color);
        // Get the selected item in the spinner
        String beerType = String.valueOf(color.getSelectedItem());
        // Get recommendation from the BeerExpert class
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandList){
            brandsFormatted.append(brand).append("\n");
        }
        // Display the beers
        brands.setText(brandsFormatted);
    }
}
