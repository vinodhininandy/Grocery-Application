package com.example.logsignsql;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
public class FoodDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        // Get data from the intent
        Intent intent = getIntent();
        if (intent != null) {
            // Create a bundle to pass data to the fragment
            Bundle args = new Bundle();
            args.putString("food_name", intent.getStringExtra("food_name"));
            args.putString("food_description", intent.getStringExtra("food_description"));
            args.putDouble("food_price", intent.getDoubleExtra("food_price", 0.0));
            args.putInt("food_image", intent.getIntExtra("food_image", R.drawable.food_img_1));

            // Create and display the fragment
            FoodDetailFragment fragment = new FoodDetailFragment();
            fragment.setArguments(args);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentContainer, fragment);
            transaction.commit();
        }
    }
}
