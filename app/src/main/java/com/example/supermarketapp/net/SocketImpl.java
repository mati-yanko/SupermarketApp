package com.example.supermarketapp.net;

import com.example.supermarketapp.ISocketActions;
import com.example.supermarketapp.ISocketEvents;

import java.net.Socket;
import java.util.ArrayList;

public class SocketImpl extends Socket implements ISocketActions {

    private ArrayList<ISocketEvents> mSubscribers = new ArrayList<>();

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    public void register(ISocketEvents subscriber) {
        mSubscribers.add(subscriber);
    }
}
