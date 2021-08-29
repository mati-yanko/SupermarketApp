package com.example.supermarketapp.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.supermarketapp.R;
import com.example.supermarketapp.controller.GroceryController;
import com.example.supermarketapp.databinding.ActivityScrollingBinding;
import com.example.supermarketapp.model.GroceryItem;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;
    private Button mOnOffButton;
    private GroceryController mGroceryProvider = new GroceryController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        mOnOffButton = findViewById(R.id.onOffButton);
        mOnOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle on/off logic
                mGroceryProvider.on();
            }
        });

        mGroceryProvider.on();
    }

    private void addGroceryItem(GroceryItem item) {
        // add item layout to UI
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}