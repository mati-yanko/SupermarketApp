package com.example.supermarketapp.controller;

import android.os.Handler;
import android.os.Looper;

import com.example.supermarketapp.GroceryRunnable;
import com.example.supermarketapp.ISocketActions;
import com.example.supermarketapp.ISocketEvents;
import com.example.supermarketapp.model.GroceryItem;
import com.example.supermarketapp.net.SocketImpl;

public class GroceryController implements ISocketActions, ISocketEvents {

    private SocketImpl mSocketImpl = new SocketImpl();
    private Handler mUIHandler;

    public GroceryController() {
        mUIHandler = new Handler(Looper.getMainLooper());
        registerSocketEvents();

    }

    @Override
    public void on() {
        mSocketImpl.on();
    }

    @Override
    public void off() {
        mSocketImpl.off();
    }

    private void registerSocketEvents() {
        mSocketImpl.register(this);
    }

    public void onDataArrived(String data) {

        // parse data
        GroceryItem newItem = new GroceryItem("1", "2", "3");

        if (mUIHandler != null) {
            Runnable itemRunnable = new GroceryRunnable(newItem);
            mUIHandler.post(itemRunnable);
        }
    }
}
