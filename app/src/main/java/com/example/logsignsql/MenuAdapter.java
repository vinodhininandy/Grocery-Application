package com.example.logsignsql;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<MenuItem> menuItems;
    private Context context;

    public MenuAdapter(Context context, List<MenuItem> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        holder.itemName.setText(menuItem.getItemName());
        holder.itemDescription.setText(menuItem.getItemDescription());
        holder.itemPrice.setText(String.format("₹%.2f", menuItem.getItemPrice()));

        Glide.with(context)
                .load(menuItem.getImageResourceId())
                .placeholder(R.drawable.food_img_1)
                .error(R.drawable.internet_bg)
                .into(holder.itemImage);

        // Set click listener for the entire item
        holder.itemView.setOnClickListener(v -> {
            // Open the FoodDetailActivity when the item is clicked
            Intent intent = new Intent(context, FoodDetailActivity.class);
            intent.putExtra("food_name", menuItem.getItemName());
            intent.putExtra("food_description", menuItem.getItemDescription());
            intent.putExtra("food_price", menuItem.getItemPrice());
            intent.putExtra("food_image", menuItem.getImageResourceId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;
        TextView itemDescription;
        TextView itemPrice;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
