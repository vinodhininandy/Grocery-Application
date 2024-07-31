package com.example.logsignsql;

public class MenuItem {
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private int imageResourceId;

    public MenuItem(String itemName, String itemDescription, double itemPrice, int imageResourceId) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.imageResourceId = imageResourceId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
