package com.example.logsignsql;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import android.widget.Toast;


public class FoodDetailFragment extends Fragment {

    public FoodDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);


        // Initialize UI elements
        ImageView detailItemImage = view.findViewById(R.id.detailItemImage);
        TextView detailItemName = view.findViewById(R.id.detailItemName);
        TextView detailItemDescription = view.findViewById(R.id.detailItemDescription);
        TextView detailItemPrice = view.findViewById(R.id.detailItemPrice);
        Button orderNowButton = view.findViewById(R.id.orderNowButton);

        // Get data from arguments
        Bundle args = getArguments();
        if (args != null) {
            String itemName = args.getString("food_name", " ");
            String itemDescription = args.getString("food_description", " ");
            double itemPrice = args.getDouble("food_price", 0.0);
            int itemImageResourceId = args.getInt("food_image",R.drawable.food_img_1);

            // Set data to the UI elements
            detailItemName.setText(itemName);
            detailItemDescription.setText(itemDescription);
            detailItemPrice.setText(String.format("₹%.2f", itemPrice));

            // Load and display the image using Glide
            Glide.with(this)
                    .load(itemImageResourceId)
                    .placeholder(R.drawable.food_img_1)
                    .error(R.drawable.internet_bg)
                    .into(detailItemImage);


            // Set click listener for the "Order Now" button
            orderNowButton.setOnClickListener(v -> {
                // Add logic to place an order or navigate to the order screen
                // For now, let's just display a message
                // You can replace this with your desired order logic
                // or navigate to another activity for order processing
                // For example:
                // startActivity(new Intent(getActivity(), OrderActivity.class));
                // getActivity().finish();
                showMessage("Order placed!");
            });
        }

        return view;
    }

    private void showMessage(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

}