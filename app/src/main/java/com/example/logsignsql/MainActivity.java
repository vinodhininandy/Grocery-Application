package com.example.logsignsql;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize buttons
        Button btnMenu = findViewById(R.id.btnMenu);

        Button btnPromotions = findViewById(R.id.btnPromotions);


            Intent serviceIntent = new Intent(this,
                    MyService.class);
        startService(serviceIntent);
        // Set click listeners for each button
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Menu button click
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }

        });



        btnPromotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Promotions button click
                startActivity(new Intent(MainActivity.this, PromotionsActivity.class));
            }
        });

    }
}
