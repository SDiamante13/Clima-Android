package com.londonappbrewery.climapm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        final EditText editTextField = findViewById(R.id.queryET);
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        editTextField.setOnEditorActionListener((v, actionId, event) -> {
            String newCity = editTextField.getText().toString();
            Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);
            newCityIntent.putExtra("City", newCity);

            setResult(Activity.RESULT_OK, newCityIntent);

            finish();
            return true;
        });

    }
}
