package com.example.logsignsql;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        TextView menuTitle = findViewById(R.id.menuTitle);
        RecyclerView recyclerViewMenu = findViewById(R.id.recyclerViewMenu);

        // Set menu title
        menuTitle.setText("Our Grocery Items");

        // Create a list of menu items with image resources (Replace this with your actual data)
        List<MenuItem> menuItems = generateSampleMenuItems();

        // Create and set up the RecyclerView adapter
        MenuAdapter menuAdapter = new MenuAdapter(this, menuItems);
        recyclerViewMenu.setAdapter(menuAdapter);

        // Set the layout manager for the RecyclerView
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<MenuItem> generateSampleMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Apples", "1Kg", 500, R.drawable.apple));
        menuItems.add(new MenuItem("Carrot", "1Kg", 250, R.drawable.carrot));
        menuItems.add(new MenuItem("Banana", "1Kg", 150, R.drawable.banana));
        menuItems.add(new MenuItem("Ginger", "half Kg", 100, R.drawable.ginger));
        menuItems.add(new MenuItem("Garlic", "Half Kg", 200, R.drawable.garlic));
        menuItems.add(new MenuItem("Orange", " 1Kg", 400, R.drawable.orange));
        menuItems.add(new MenuItem("Pomegranate", "1Kg", 500, R.drawable.pome));
        menuItems.add(new MenuItem("Tomato", "1Kg", 350, R.drawable.tomatoes));
        menuItems.add(new MenuItem("Onion", "1Kg", 400, R.drawable.onions));

        // Add more menu items as needed
        return menuItems;
    }
}