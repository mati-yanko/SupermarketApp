package com.example.supermarketapp;

import android.app.Activity;

import com.example.supermarketapp.model.GroceryItem;
import com.example.supermarketapp.ui.ScrollingActivity;

public class GroceryRunnable implements Runnable {

    private GroceryItem mItem;
    @Override
    public void run() {
        // give ui Activity the data
    }

    public GroceryRunnable(GroceryItem item) {
        mItem = item;
    }
    public GroceryItem getItem() {
        return mItem;
    }
}
